package console.objects.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import data.model.Product;



public class ClientSideApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo to process a list of objects on TCP \n");

		// Request data
		Product product1 = new Product();
		product1.setName("Programming Lab 1");
		
		Product product2 = new Product();
		product2.setName("Multimedia Studio");
		
		Product product3 = new Product();
		product3.setName("Research Lab");
		
		// Add into list
		List<Product> products = new ArrayList<Product>();
		products.add(product3);
		products.add(product1);
		products.add(product2);

		try {

			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + products);
			outputStream.writeObject(products);
			outputStream.flush();
			
			// Open stream to receive object
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream, cast and display details
			products = (ArrayList<Product>) inputStream.readObject();
			for (Product product:products)
				System.out.println ("Id for " + product.getName() + " is " + product.getProductId());
			
			// Close all closeable objects
			outputStream.close();
			inputStream.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}
