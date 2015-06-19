package chapter9;

public class TestRectangle {
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle();
		System.out.println("The area of the rectangle of width and height " 
				+ rectangle1.width + ", " + rectangle1.height + " is " + rectangle1.getArea());
		System.out.println("The perimeter of the rectangle of width and height " 
				+ rectangle1.width + ", " + rectangle1.height + " is " + rectangle1.getPerimeter());
		System.out.println();
		
		Rectangle rectangle2 = new Rectangle(4, 40);
		System.out.println("The area of the rectangle of width and height " 
				+ rectangle2.width + ", " + rectangle2.height + " is " + rectangle2.getArea());
		System.out.println("The perimeter of the rectangle of width and height " 
				+ rectangle2.width + ", " + rectangle2.height + " is " + rectangle2.getPerimeter());
		System.out.println();
		
		Rectangle rectangle3 = new Rectangle(3.5, 35.9);
		System.out.println("The area of the rectangle of width and height " 
				+ rectangle3.width + ", " + rectangle3.height + " is " + rectangle3.getArea());
		System.out.println("The perimeter of the rectangle of width and height " 
				+ rectangle3.width + ", " + rectangle3.height + " is " + rectangle3.getPerimeter());
		System.out.println();
	}
}
