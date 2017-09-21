package instagramTracker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {

	
	public static void main(String[] args) {
	
		Socket s = new Socket();
		String host = "localhost:8000";
		
		try {
			s.connect(new InetSocketAddress(host, 80));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("connected to: " + host);
	}
}
