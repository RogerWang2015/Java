package chapter7;

import java.util.Scanner;

public class AssignGrades {
	
	public static void main(String[] args){
		int count;
	
		double best = 100.0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		count = input.nextInt();
		double[] score = new double[count];
		char[] grade = new char[count];
		System.out.println("Enter " + count + " scores: " );
		
		for(int i = 0; i<count; i++){
			 
			score[i] = input.nextDouble();
			if(score[i] > (best - 10)||score[i] == (best - 10)){
				grade[i] = 'A';
			}
			else if(score[i] > (best - 20)||score[i] == (best - 20)){
				grade[i] = 'B';
			}
			else if(score[i] > (best - 30)||score[i] == (best - 30)){
				grade[i] = 'C';
			}
			else if(score[i] > (best - 40)||score[i] == (best - 40)){
				grade[i] = 'D';
			}
			else grade[i] = 'F';
		}
		for(int i = 0; i<count; i++){
			System.out.println("Student " + i + " is "  + score[i] + " and grade is "  + grade[i]);
		}
		
		input.close();
	}
	
}
