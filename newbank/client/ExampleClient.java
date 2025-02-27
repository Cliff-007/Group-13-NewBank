package newbank.client;

import newbank.server.NewBankServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import newbank.server.NewBankServer;

public class ExampleClient extends Thread{
	
	private Socket server;
	private PrintWriter bankServerOut;	
	private BufferedReader userInput;
	private Thread bankServerResponseThread;
	
	public ExampleClient(String ip, int port) throws UnknownHostException, IOException {
		server = new Socket(ip,port);
		userInput = new BufferedReader(new InputStreamReader(System.in)); 
		bankServerOut = new PrintWriter(server.getOutputStream(), true); 
		
		bankServerResponseThread = new Thread() {
			private BufferedReader bankServerIn = new BufferedReader(new InputStreamReader(server.getInputStream())); 
			public void run() {
				try {
					while(true) {
						String response = bankServerIn.readLine();
						if (response != null){
							System.out.println(response);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
			}
		};
		bankServerResponseThread.start();
	}
	
	
	public void run() {
		while(true) {
			try {
				while(true) {
					String command = userInput.readLine();
					bankServerOut.println(command);
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		//NewBankServer server = new NewBankServer(14002);
		//server.start();
		
		new ExampleClient("localhost",14002).start();
	}
}
