import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.InetAddress; 
import java.net.Socket; 
import java.net.UnknownHostException; 
import java.util.Scanner; 
  
public class Client 
{ 
    public static void main(String[] args) throws IOException 
    { 
        InetAddress ip = InetAddress.getLocalHost(); 
        int port = 4444; 
        Scanner sc = new Scanner(System.in); 

        Socket s = new Socket(ip, port); 

        DataInputStream dataInStream = new DataInputStream(s.getInputStream()); 
        DataOutputStream dataOutStream = new DataOutputStream(s.getOutputStream()); 

        while (true)
        {
            System.out.println("To exit, enter Bye."); 
            System.out.print("Enter a number to check if it is prime: ");

            String in = sc.nextLine(); 

            dataOutStream.writeUTF(in);
  
            if (in.equals("Bye")) break;
            String ans = dataInStream.readUTF(); 
            System.out.println("Answer=" + ans); 
        } 
    } 
}