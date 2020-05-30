import java.io.*;
import java.util.*;
class LoadBalance{
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Enter no. of servers:");
		 
		 int tot_servers = Integer.parseInt(br.readLine());
		 System.out.println("Enter no. of processes:");
		 
		 int tot_process = Integer.parseInt(br.readLine());   		 
		 disp_load(tot_servers, tot_process);
		 
		 loop:while(true){
		 System.out.println("\n1.Add server\n2.Delete Server\n3.Add Process\n4.Delete Process\n5.Exit\nEnter choice:");

		 int ch = Integer.parseInt(br.readLine());
		 switch(ch){
			 case 1:	 tot_servers++;
				 disp_load(tot_servers, tot_process);
				 break;    
			 case 2:	 tot_servers--;
				 disp_load(tot_servers, tot_process);
				 break;
			 case 3:	 tot_process++;
				 disp_load(tot_servers, tot_process);
				 break;
			 case 4: tot_process--;
				 disp_load(tot_servers, tot_process);
				 break;
			 case 5:	 break loop;    
			 default:	 System.out.println("Enter valid choice");	}   
}	
}
	static void disp_load(int tot_servers, int tot_process){
		 int div = (int)tot_process/tot_servers;
		 ArrayList<Integer> servers = new ArrayList<>();
		 for(int i=0;i<tot_servers;i++){
			 servers.add(div);	
}
		 int rem = tot_process - (tot_servers*div);
		 for(int i=0;i<rem;i++){
			 servers.set(i%tot_servers, servers.get(i%tot_servers)+1);    	}
		 
		 for(int i=0;i<tot_servers;i++){
			 System.out.println("Server " + (i+1) + ":" + servers.get(i));    
		 }
		}
}
