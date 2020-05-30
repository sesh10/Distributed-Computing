import java.rmi.*;  
public interface Adder extends Remote{  
	public int add(int x,int y)throws RemoteException; 
	public int subtract(int x,int y)throws RemoteException;
	public float multiply(float x,float y)throws RemoteException;
	public float divide(float x,float y)throws RemoteException;
	public int mod(int x,int y)throws RemoteException;
}  
