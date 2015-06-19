package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
	public static void main(String[] args) throws IOException{
		try(
				FileOutputStream output = new 
				FileOutputStream("Exercise17_01.txt");
				){
			for(int i = 1; i <= 100; i++){
				int w = (int)(1 + Math.random() * 100);
				output.write(w);
			}
		}
		try(
				FileInputStream input = new 
				FileInputStream("Exercise17_01.txt");
				){
			int value;
			while((value = input.read()) != -1)
				System.out.print(value + " ");
		}
	}

}
