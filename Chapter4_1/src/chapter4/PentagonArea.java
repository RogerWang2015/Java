package chapter4;

import java.util.Scanner;

public class PentagonArea {
	public static void main(String[] args){
		//Create a Scanner object
		//@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		final double PI = 3.1415926;
		
		//Step1: Read in radius and length
		double radius; //declare radius variable
		double s; //declare side variable
		double area; //declare area variable
	 
		
		//Assign a radius and a length
		
		System.out.println("Enter the length from the center to a vertex for radius: ");
		radius = input.nextDouble();
		
		s = 2 * radius * Math.sin(PI/5.0);
		
		//Step2: Compute Area
		area =  (5 * s * s)/(4 * Math.tan(PI/5.0));
		 
		
		
		
		//Step3: Display the area
		System.out.printf("The area for the pentagon of radius of " + radius + "  is %4.2f " ,  area);
		
		//Close input
		input.close();
	} 

}
