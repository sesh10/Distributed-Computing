import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class Lamport{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int max = 1000;
		System.out.println("-----Lamport Algorithm-----");
		System.out.println("Enter all inputs of process ids as zero-indexed");
		System.out.println("Enter total no. of processes");
		int noOfProcesses = sc.nextInt();
		int requestArray[][] = new int[noOfProcesses][2];
		for (int i=0; i<noOfProcesses; i++) {
			requestArray[i][0] = 0;
			requestArray[i][1] = max;
		}
		System.out.println("How many processes want to execute the critical region?");
		int noOfProcessesCriticalRegion = sc.nextInt();
		System.out.println("Enter ids of the processes entering critical region");
		for (int i=0; i<noOfProcessesCriticalRegion; i++) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Enter process id for " + i + "th process");
			int processId = sc.nextInt();
			System.out.println("Enter the timestamp");
			int timestamp = sc.nextInt();
			requestArray[processId][0] = processId;
			requestArray[processId][1] = timestamp;
			System.out.println();
			System.out.println("Process " + processId + " is sending request to enter critical region");
			for (int j=0; j<noOfProcesses; j++) {
				if(j != processId){
					System.out.println("Request sent to process " + j);}}
			System.out.println();
			System.out.println("All processes have received the request sent by process " + processId);
			System.out.println("All processes reply back to process " + processId);
			for (int j=0; j<noOfProcesses; j++) {
				if(j != processId){
					System.out.println("Reply received from process " + j);
				}
			}}
		for (int i=0; i<noOfProcessesCriticalRegion; i++) {
			int minTimestamp = max;
			int minTimestampIndex = 0;
			for (int j=0; j<noOfProcesses; j++) {
				if(requestArray[j][1] < minTimestamp){
					minTimestamp = requestArray[j][1];
					minTimestampIndex = j;
				}
			}
			System.out.println("----------------------------------------------------------------");
			System.out.println("Process " + minTimestampIndex + " will get a chance to enter Critical region since it has a minimum timestamp of " + minTimestamp);

			int executionTime = 1 + (int)(Math.random() * ((5 - 1) + 1));
			System.out.println("The process " + minTimestampIndex + " will execute for " + executionTime + " seconds");

			try{
				TimeUnit.SECONDS.sleep(executionTime);	
			}
			catch(InterruptedException e){
				System.out.println("Unexpected interrupt");
			}
			System.out.println();
			System.out.println("Process " + minTimestampIndex + " has completed executing in critical region");
			System.out.println("Resetting the timestamp of process " + minTimestampIndex);
			requestArray[minTimestampIndex][1] = max;
			System.out.println();
			System.out.println("Process " + minTimestampIndex + " is sending release message to all processes");
			for (int j=0; j<noOfProcesses; j++) {
				if(j != minTimestampIndex){
					System.out.println("Release sent to process " + j);
				}
			}
		}
		System.out.println("All requesting processes have completed executing in the critical region");
	}
}
