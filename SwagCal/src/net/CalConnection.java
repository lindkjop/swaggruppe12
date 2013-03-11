package net;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;


public class CalConnection implements Connection {

	@Override
	public void connect(InetAddress remoteAddress, int remotePort) throws IOException, SocketTimeoutException {
		
		
	}

	@Override
	public Connection accept() throws IOException, SocketTimeoutException {
		
		return null;
	}

	@Override
	public void send(String msg) throws ConnectException, IOException {
		
		
	}

	@Override
	public String receive() throws ConnectException, IOException {
		
		return null;
	}

	@Override
	public void close() throws IOException {
		
		
	}
}
