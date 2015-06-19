package compute;

import java.util.Scanner;

public class ComputeVolume {
	public static void main(String[] args){
		//Create a Scanner object
		//@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		//Step1: Read in radius and length
		double radius; //declare radius variable
		double length; //declare length variable
		double area; //declare area variable
		double volume; //declare volume variable
		
		//Assign a radius and a length
		//radius = 20; //radius is now 20
		System.out.println("Enter a number for radius: ");
		radius = input.nextDouble();
		
		//length = 10; //length is now 10
		System.out.println("Enter a number for length: ");
		length = input.nextDouble();
		
		//Step2: Compute Area
		area = radius * radius * 3.14159;
		volume = area * length;
		
		//Close input
		input.close();
		
		//Step3: Display the area
		System.out.println("The area for the circle of radius " +
		radius + " is " + area);
		System.out.println("The volume for the circle of radius and length " +
				radius + " and " + length + " is " + volume);
		
	}


}
