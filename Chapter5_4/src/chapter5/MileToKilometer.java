package chapter5;

public class MileToKilometer {
	public static void main(String[] args){
		double Kilo;
		//Display the table heading
		System.out.println(" Conversion from miles to kilometers");
		System.out.println("\n------------------------------------------");
		System.out.println("Miles         Kilometers");
		//Display table body
		for(int i = 1; i<=10; i++){
			Kilo = i * 1.609;
			System.out.printf("%2d", i );
			System.out.printf("              %4.3f", Kilo );
			System.out.println();
		}//End of loop
		
	}//End of main

}//End of class
