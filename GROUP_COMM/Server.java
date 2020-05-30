import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.StringTokenizer; 

public class Server 
{ 
    public static boolean prime(int n) {
        for (int i = 2; i < n/2 + 1; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

	public static void main(String args[]) throws IOException 
	{ 

        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Waiting for connection...");
		Socket s = ss.accept(); 
        System.out.println("Client connected!");
		DataInputStream dataInStream = new DataInputStream(s.getInputStream()); 
		DataOutputStream dataOutStream = new DataOutputStream(s.getOutputStream()); 

		while (true) 
		{ 
			String input = dataInStream.readUTF(); 

			if(input.equals("Bye")) 
                break;
            
			System.out.println("Number received: " + input);
            int result;
            int n = Integer.parseInt(input);
            boolean ans = prime(n);

            System.out.println("Sending the result...");
			dataOutStream.writeUTF(Boolean.toString(ans)); 
		} 
	} 
} 
