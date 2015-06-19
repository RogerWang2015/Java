package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeThread {
	private static Count count = new Count();
	public static void main(String[] args){
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i< 1000; i++){
			executor.execute(new AddOneTask());
		}
		executor.shutdown();
		
		while(!executor.isTerminated()){
			
		}
		System.out.println("What is the total count? " + count.getSum());
		
	}
	private static class AddOneTask implements Runnable{
		public void run(){
			count.counting(1);
		}
	}
	
	private static class Count{
		private int sum = 0;
		
		public int getSum(){
			return sum;
		}
		
		public  synchronized void counting(int number){
			int newSum = sum + number;
		
		try{
			Thread.sleep(5);
		}
		catch(InterruptedException ex){
			
		}
		sum = newSum;
		}	
	}

}
