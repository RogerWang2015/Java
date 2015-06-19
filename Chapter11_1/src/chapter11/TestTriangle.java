package chapter11;

public class TestTriangle {
	public static void main(String[] args){
		TriangleFromSimpleGeometricObject triangle =
				new TriangleFromSimpleGeometricObject(2.8, 4.1, 6.2);
		System.out.println("A triangle " + triangle.toString());
		System.out.println("The color is " + triangle.getColor());
		System.out.println("The side1 is " + triangle.getSide1());
		System.out.println("The side2 is " + triangle.getSide2());
		System.out.println("The side3 is " + triangle.getSide3());
		System.out.println("The area is  " + triangle.getArea());
		System.out.println("The perimeter is  " + triangle.getPerimeter());
	}
}
