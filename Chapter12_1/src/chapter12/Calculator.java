package chapter12;

//import java.util.Scanner;

public class Calculator {
	//Scanner input = new Scanner(System.in);
	public static int quotient(String[] m){
	if(m.length != 3){
		throw new IllegalArgumentException("Wrong Argument");
		
					}
		int result = 0;
		
		switch(m[1].charAt(0)){
		case '+':
			result = Integer.parseInt(m[0]) +
					 Integer.parseInt(m[2]);
			break;
		
		case '-':
			result = Integer.parseInt(m[0]) -
					 Integer.parseInt(m[2]);
			break;
			
		case '.':
			result = Integer.parseInt(m[0]) *
					 Integer.parseInt(m[2]);
			break;
			
		case '/':
			result = Integer.parseInt(m[0]) /
					 Integer.parseInt(m[2]);
			 
		}
		return result;
	}
	public static void main(String[] args){
		
		/**Scanner input = new Scanner(System.in); 
		String[] n = new String[3] ;
		System.out.println("Input three strings for calculate: ");
		for(int i = 0; i < 3; i++){
			n[i] = input.next();
		}**/
		
		try{
			
			int result1 = quotient(args);
			
		 
		System.out.println(args[0] + ' ' + args[1] + ' ' 
				+ ' ' + args[2] + " = "  + result1);
			
		}
		catch(IllegalArgumentException ex){
			System.out.println("Exception: Three args needed ");
		}
		//input.close();
		System.out.println("Execution continues...");
	}

}
