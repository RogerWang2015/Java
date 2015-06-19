package chapter31server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


@SuppressWarnings("restriction")
public class Chapter31_01Server extends Application {

	@SuppressWarnings("resource")
	public void start(Stage primaryStage){
		TextArea ta = new TextArea();
		
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Exercise31_01Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() -> {
			try{
		 
			 
			ServerSocket serverSocket = new ServerSocket(8000);
			Platform.runLater(() -> 
				ta.appendText("Exercise31_01Server started at "
						+ new Date() + '\n'));
			
			Socket socket = serverSocket.accept();
			
			ObjectInputStream inputFromClient = new ObjectInputStream(
					socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(
					socket.getOutputStream());
			
		    LoanDetail object;
			try {
				object = (LoanDetail) inputFromClient.readObject();
				double AnnualIntRate = Double.parseDouble(object.getAnnualIntRate().trim());
				double NumOfYears = Double.parseDouble(object.getNumOfYears().trim());
				double LoanAmount = Double.parseDouble(object.getLoanAmount().trim());
				double monthlyInterestRate = AnnualIntRate/1200;
				double monthlyPayment = LoanAmount * monthlyInterestRate/(1
						- 1/Math.pow(1 + monthlyInterestRate, NumOfYears * 12));
				double totalPayment = monthlyPayment * NumOfYears * 12;
				 
				
				outputToClient.writeDouble(monthlyPayment);
				
				Platform.runLater(() -> {
					
				
					ta.appendText("monthlyPayment: " + monthlyPayment + '\n');
					ta.appendText("totalPayment: " + totalPayment + '\n');
					
				});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		  
			
		}).start();
		 
	}
	public static void main(String[] args){
		Application.launch(args);
	} 
	 
	}

