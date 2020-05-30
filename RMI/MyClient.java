import java.rmi.*;
import java.util.*;
  
public class MyClient{  
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);  
		try{  
			Adder stub=(Adder)Naming.lookup("rmi://localhost:5001/C:/Users/Student/Desktop/rmi");  
			System.out.println("Which method do you want to    use\n1.add\n2.subtract\n3.multiply\n4.divide\n5.mod\nEnter the method number : ");
			int method_number = sc.nextInt();
			int a,b;
			float a1,b1;
			switch(method_number)
			{
				case 1: System.out.println("Enter two numbers : ");
					a=sc.nextInt();
					b=sc.nextInt();
					System.out.println("Addition result is : "+ stub.add(a,b));
					break;
				
				case 2: System.out.println("Enter two numbers : ");
					a=sc.nextInt();
					b=sc.nextInt();
					System.out.println("Subtraction result is : "+ stub.subtract(a,b));
					break;
				
				case 3: System.out.println("Enter two numbers : ");
					a1=sc.nextFloat();
					b1=sc.nextFloat();
					System.out.println("Multiplication result is : "+ stub.multiply(a1,b1));
					break;		
				
				case 4: System.out.println("Enter two numbers : ");
					a1=sc.nextFloat();
					b1=sc.nextFloat();
					System.out.println("Division result is : "+ stub.divide(a1,b1));
					break;
				
				case 5: System.out.println("Enter two numbers : ");
					a=sc.nextInt();
					b=sc.nextInt();
					System.out.println("Reminder is : "+ stub.mod(a,b));
					break;

				default: System.out.println("No such method..!!");
					 break;
			}
  
		}catch(Exception e){}  
	}  
}  
