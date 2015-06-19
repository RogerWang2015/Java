package chapter8;

import java.util.Scanner;

public class SumColumnByColumn {
	public static void main(String[] args){
		double[][] array = getArray();
		for(int j = 0; j<4; j++){
			 
			System.out.println("Sum of the elements at column " + j + " is " + sumColumn(array, j));
		}
		
	}
	public static double sumColumn(double[][] m, int columnIndex){
		
		
		int row = m.length;
		double sum = 0;
				 
			for(int i = 0; i < row; i++){
				sum += m[i][columnIndex];
			}
		return sum;
		
	}
	public static double[][] getArray(){
		Scanner input = new Scanner(System.in);
		
		double[][] m = new double[3][4];
		System.out.println("Enter " + m.length + " rows and " +
		m[0].length + " columns: ");
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[i].length; j++){
				m[i][j] = input.nextDouble();
			}
		}
		input.close();
		return m;
	}
}
