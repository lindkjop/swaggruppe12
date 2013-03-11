package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServerMulti 
{
	private int port;
	private String serverAdress;
	
	public HelloWorldServerMulti(int port,String serverAdress)
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
			
			while (true) {
				new HelloWorldServerThread(serverSocket.accept()).start();
					
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new HelloWorldServerMulti(7899, "127.0.0.1").startServer();
	}
}
