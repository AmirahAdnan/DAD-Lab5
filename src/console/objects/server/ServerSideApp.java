package console.objects.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import data.model.Product;



public class ServerSideApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		try {
			
			// Port to receive and respond to request
			int portNo = 4228;
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println("Ready for request");
			
			// Server need to be alive forever thus the while(true)
			while (true) {
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read object
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				
				// Read object from stream and cast it to ArrayList of Location
				List<Product> products = (ArrayList<Product>) inputStream.readObject();
				
				// Process object - assign location id
				for (int index=0; index < products.size(); index++) {
					
					Product currentLocation = products.get(index);
					currentLocation.setProductId((index + 1) * 1000);
				}
				
				// Create output stream to send object
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(products);
				
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
