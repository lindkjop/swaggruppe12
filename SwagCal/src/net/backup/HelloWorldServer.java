package net.backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer 
{
	private int port;
	private String serverAdress;
	
	public HelloWorldServer(int port,String serverAdress)
	{
		this.port = port;
		this.serverAdress = serverAdress;
	}
	
	public void startServer()
	{
		try 
		{	
			//Start listening on the ports and adress provided in the constructor
			ServerSocket serverSocket = new ServerSocket(this.port,50,InetAddress.getByName(this.serverAdress));
			System.out.println("WAITING FOR CONNECTIONS ON "+this.serverAdress+":"+this.port);
			
			//Get a new fresh socket for communicating with the client, we dont use the serversocket
			Socket clientSocket = serverSocket.accept();
			
			//Print out the adress and socket of the client socket. You will see that the port is different, this is because the serversocket uses the 7899
			//port, so the client is assigned an unused port
			System.out.println("CONNECTED TO CLIENT ON "+clientSocket.getRemoteSocketAddress());
			
			//This is commented in the HelloWorldClient class
			InputStream clientInputStream = clientSocket.getInputStream();
			OutputStream clientOutputStream = clientSocket.getOutputStream();
			InputStreamReader inFromClient = new InputStreamReader(clientInputStream);
			BufferedReader StringFromClient = new BufferedReader(inFromClient);
			PrintWriter outToClient = new PrintWriter(clientOutputStream,true);
			System.out.println("WAITING FOR MESSAGE FROM CLIENT");
			while (true)
			{
				String fromClient = StringFromClient.readLine();
				System.out.println("MESSAGE FROM CLIENT: "+fromClient);
				outToClient.println("MESSAGE RECEIVED ON SERVER: "+fromClient);
				System.out.println(clientSocket.getLocalSocketAddress());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new HelloWorldServer(7899, "127.0.0.1").startServer();
	}
}
