package chapter6;

public class PentagonalNumbers {
	public static void main(String[] args){
		getPentagonalNumber(100);
	}//End of main
	public static int getPentagonalNumber(int n){
		int pcount = 1;
		int result = 0;
		for(int i = 1; i <= n; i++){
			result = i *(3 * i -1)/2;
			System.out.printf("%10d", result);
			
			if(pcount == 10){
				System.out.println();
				pcount = 0;
			}
			pcount++;
			
		}
		return result;
	}//End of method
	
}
