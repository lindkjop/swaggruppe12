package net.backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloWorldClient 
{
	private int serverPort;
	private String serverAdress;
	
	//Constructor
	public HelloWorldClient(int serverPort,String serverAdress)
	{
		this.serverPort = serverPort;
		this.serverAdress = serverAdress;
	}
	
	public void startClient()
	{
		try 
		{	
			//Establish connection to server
			Socket serverConnection = new Socket(InetAddress.getByName(this.serverAdress),this.serverPort);
			System.out.println("CONNECTED TO SERVER");
			
			//Get a reference to the inputstream of the socket, in order to get the data from the other end (this is esentially a stream of bytes)
			InputStream serverInputStream = serverConnection.getInputStream();
			
			//Wrap the raw inputstream into a character stream (from raw bytes to characters)
			InputStreamReader inFromServer = new InputStreamReader(serverInputStream);
			
			//Wrap the character streams into a buffer that enables us to read out one line at a time
			BufferedReader StringFromServer = new BufferedReader(inFromServer);
			
			//Get a reference to the outputstream of the socket, in order to send data
			OutputStream serverOutputStream = serverConnection.getOutputStream();
			
			//Wrap the outputstream into a convenient printwriter object, it enables us to send Strings by using the println method
			PrintWriter outToServer = new PrintWriter(serverOutputStream,true);
			System.out.println("SAY SOMETHING NICE TO THE SERVER");
			
			//Read user input (we let the user say something to the server)
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
			//Start an infinite loop - say something to the server, wait for a response, print the response and start over
			while(true)
			{
				//get user input
				String userInput = inFromUser.readLine();
				
				//send the input string
				outToServer.println(userInput);
				
				//get for the response from the server
				String responseFromServer = StringFromServer.readLine();
				
				//print the response
				System.out.println(responseFromServer);
			}
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		//Start the client by calling the constructor and start method
		new HelloWorldClient(7899,"127.0.0.1").startClient();
	}
}
