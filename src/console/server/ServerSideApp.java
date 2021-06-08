package console.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import data.model.Product;


/**
 * This class demonstrate the application of ObjectInputStream and 
 * ObjectOutputStream at the server-side application.
 * 
 * How to run this program?
 * 
 * 1. Open Terminal
 * 2. Change the directory to /workspace-dad/demoObjectStream/bin
 * 3. Run -> java console.server.ServerSideApp
 * 
 * @author emalianakasmuri
 *
 */

public class ServerSideApp {

	/**
	 * Main entry point of application
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			// Port to receive and respond to request
			int portNo = 4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println("Ready for request");
			
			// Server need to be alive forever thus the while(true)
			while (true) {
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read object
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				
				// Read object from stream and cast to Location
				Product product = (Product) inputStream.readObject();
				
				// Process object
				product.setProductId(1);
				
				// Create output stream to send object
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(product);
				
				
				System.out.println("Ready for next request");
				
				// Close all streams
				inputStream.close();
				outputStream.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
