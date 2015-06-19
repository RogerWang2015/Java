package compute;

public class ComputeArea {
	public static void main(String[] args){
		//Step1: Read in radius
		double radius; //declare radius variable
		double area; //declare area variable
		//Assign a radius
		radius = 20; //radius is now 20
		
		//Step2: Compute Area
		area = radius * radius * 3.14159;
		
		//Step3: Display the area
		System.out.println("The area for the circle of radius " +
		radius + " is " + area);
	}

}
