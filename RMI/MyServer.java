import java.rmi.*;  
import java.rmi.registry.*; 
 
public class MyServer{  
	public static void main(String args[]){  
		try{  
			Adder stub=new AdderRemote();  
			Naming.rebind("rmi://localhost:5001/C:/Users/Student/Desktop/rmi",stub);  
		}catch(Exception e){System.out.println(e);}  
	}  
} 
