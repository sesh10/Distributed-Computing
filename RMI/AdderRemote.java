import java.rmi.*;  
import java.rmi.server.*;  
public class AdderRemote extends UnicastRemoteObject implements Adder{  
	AdderRemote() throws RemoteException{  
		super();  
	}  
	public int add(int x,int y){return x+y;} 

	public int subtract(int x,int y){return x-y;}

	public float multiply(float x,float y){return x*y;}

	public float divide(float x,float y){return x/y;}

	public int mod(int x,int y){return x%y;}
 
 
}  
