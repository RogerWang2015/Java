package list31;
import java.io.*;
import java.net.*;
//import java.net.ServerSocket;
 
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;

@SuppressWarnings("restriction")
public class Server extends Application {
	public void start(Stage primaryStage){
		TextArea ta = new TextArea();
		
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Sever");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() -> 
						ta.appendText("Server started at " + new Date() + '\n'));
				
				Socket socket = serverSocket.accept();
				
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
						socket.getOutputStream());
				
				while(true){
					double radius = inputFromClient.readDouble();
					
					double area = radius * radius * Math.PI;
					
					outputToClient.writeDouble(area);
					
					Platform.runLater(() -> {
						ta.appendText("Radius received from client: "
								 + radius + '\n');
						ta.appendText("Area is: " + area + '\n');
					});
					serverSocket.close();
				}
				
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}).start();
		
	}
	public static void main(String[] args){
		System.out.println("Launch application");
		Application.launch(args);
	}
}
