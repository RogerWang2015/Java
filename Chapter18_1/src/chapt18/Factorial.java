package chapt18;
import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a nonnegative integer: ");
		long n = input.nextLong();
		
		System.out.println("Factroial of " + n + " is " + factorial(n));
		input.close();
	}

	public static BigInteger factorial(long n){
		BigInteger result = new  BigInteger(n +"");
		if(n == 0){
			return new BigInteger("1");
		}
		else{
			
			
			result = result.multiply(factorial(n-1));
		}
		return result;
}
}
