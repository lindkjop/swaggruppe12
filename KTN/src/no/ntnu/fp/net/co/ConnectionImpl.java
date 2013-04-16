/*
 * Created on Oct 27, 2004
 */
package no.ntnu.fp.net.co;

import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import no.ntnu.fp.net.admin.Log;
import no.ntnu.fp.net.cl.ClException;
import no.ntnu.fp.net.cl.ClSocket;
import no.ntnu.fp.net.cl.KtnDatagram;
import no.ntnu.fp.net.cl.KtnDatagram.Flag;

/**
 * Implementation of the Connection-interface. <br>
 * <br>
 * This class implements the behaviour in the methods specified in the interface
 * {@link Connection} over the unreliable, connectionless network realised in
 * {@link ClSocket}. The base class, {@link AbstractConnection} implements some
 * of the functionality, leaving message passing and error handling to this
 * implementation.
 * 
 * @author Sebjørn Birkeland and Stein Jakob Nordbø
 * @see no.ntnu.fp.net.co.Connection
 * @see no.ntnu.fp.net.cl.ClSocket
 */
public class ConnectionImpl extends AbstractConnection {
	private KtnDatagram recivedDatagram;
    private ClSocket socket = new ClSocket();

	
	
	
    /** Keeps track of the used ports for each server port. */
    private static Map<Integer, Boolean> usedPorts = Collections.synchronizedMap(new HashMap<Integer, Boolean>());

    /**
     * Initialise initial sequence number and setup state machine.
     * 
     * @param myPort
     *            - the local port to associate with this connection
     */
    public ConnectionImpl(int myPort) {
        this.myPort = myPort;
        this.myAddress = getIPv4Address();
        this.state = State.CLOSED;
    }

    private String getIPv4Address() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    /**
     * Establish a connection to a remote location.
     * 
     * @param remoteAddress
     *            - the remote IP-address to connect to
     * @param remotePort
     *            - the remote portnumber to connect to
     * @throws IOException
     *             If there's an I/O error.
     * @throws java.net.SocketTimeoutException
     *             If timeout expires before connection is completed.
     * @throws ClException 
     * @see Connection#connect(InetAddress, int)
     */
    public void connect(InetAddress remoteAddress, int remotePort) throws IOException,
            SocketTimeoutException {
    	KtnDatagram data = constructInternalPacket(Flag.SYN);
    	
    	try {
			simplySendPacket(data);
			socket.send(data);
			receiveAck();
			socket.receive(remotePort);
			data = constructInternalPacket(Flag.ACK);
			simplySendPacket(data);
			socket.send(data);
		
    	} catch (ClException e) {
    		e.printStackTrace();
    		
		}
    	
    	
    	
    	
    }

    /**
     * Listen for, and accept, incoming connections.
     * 
     * @return A new ConnectionImpl-object representing the new connection.
     * @see Connection#accept()
     */
    public Connection accept() throws IOException, SocketTimeoutException {
    	
    	receivePacket(false);
    	constructInternalPacket(Flag.SYN_ACK);
    	KtnDatagram data = new KtnDatagram();
    	try {
			simplySendPacket(data);
			receiveAck();
		} catch (ClException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return this;
    	
    	
    }

    /**
     * Send a message from the application.
     * 
     * @param msg
     *            - the String to be sent.
     * @throws ConnectException
     *             If no connection exists.
     * @throws IOException
     *             If no ACK was received.
     * @see AbstractConnection#sendDataPacketWithRetransmit(KtnDatagram)
     * @see no.ntnu.fp.net.co.Connection#send(String)
     */
    public void send(String msg) throws ConnectException, IOException {
    	
    	KtnDatagram dataGram  = constructDataPacket(msg);
    	sendDataPacketWithRetransmit(dataGram);
    	
    }

    /**
     * Wait for incoming data.
     * 
     * @return The received data's payload as a String.
     * @see Connection#receive()
     * @see AbstractConnection#receivePacket(boolean)
     * @see AbstractConnection#sendAck(KtnDatagram, boolean)
     */
    public String receive() throws ConnectException, IOException {
        throw new NotImplementedException();
    }

    /**
     * Close the connection.
     * 
     * @see Connection#close()
     */
    public void close() throws IOException {
    	
    	KtnDatagram data = constructInternalPacket(Flag.FIN);
    	sendDataPacketWithRetransmit(data);
    	try {
			socket.send(data);
			receiveAck();
			socket.receive(remotePort);
			
			sendAck(data, true);
			
			constructInternalPacket(Flag.ACK);
			socket.send(data);
			
			
			
		} catch (ClException e) {
			
			e.printStackTrace();
		}
    	
    	
    	
    }

    /**
     * Test a packet for transmission errors. This function should only called
     * with data or ACK packets in the ESTABLISHED state.
     * 
     * @param packet
     *            Packet to test.
     * @return true if packet is free of errors, false otherwise.
     */
    protected boolean isValid(KtnDatagram packet) {
    	
    	
    		long checkSum = packet.getChecksum();
    		long checkSum2 = packet.calculateChecksum();
    		return (checkSum == checkSum2);	
    	}
    
    }
