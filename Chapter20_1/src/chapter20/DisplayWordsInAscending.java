package chapter20;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DisplayWordsInAscending {
	public static void main(String[] args){
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		Scanner input = new Scanner(System.in);
		int n;
		System.out.println("Enter how many words you want to type: ");
	    n = input.nextInt();
	    String[] str = new String[n];
	    
	    
	    for(int i = 0; i < n; i++){
	    str[i] = input.next();
	    queue1.offer(str[i]);
	    }
	    
	    System.out.println(n + " words in ascending alphebetic order: ");
	    while(queue1.size() > 0){
	    	System.out.print(queue1.remove() + " ");
	    }
		input.close();
	}

}
