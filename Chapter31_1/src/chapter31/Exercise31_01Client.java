package chapter31;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class Exercise31_01Client extends Application {
	
	private TextField tfAnnualIntRate = new TextField();
	private TextField tfNumOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();
	private TextArea ta = new TextArea();
	
	
	private Button btSubmit = new Button("Submit");
	
	String host = "localhost";
	
	public void start(Stage primaryStage){
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Annual Interesting Rate"), 0, 0);
		gridPane.add(tfAnnualIntRate, 1, 0);
		gridPane.add(new Label("Number Of Years"), 0, 1);
		gridPane.add(tfNumOfYears, 1, 1);
		gridPane.add(new Label("Loan Amount"), 0, 2);
		gridPane.add(tfLoanAmount, 1, 2);
		HBox hBox = new HBox(1);
		gridPane.add(hBox, 2, 1);
		hBox.getChildren().addAll(btSubmit);
		
		gridPane.setAlignment(Pos.CENTER);
		tfAnnualIntRate.setPrefColumnCount(10);
		tfNumOfYears.setPrefColumnCount(5);
		tfLoanAmount.setPrefColumnCount(10);
		
		btSubmit.setOnAction(new ButtonListener());
		
		BorderPane mainPane = new BorderPane();
		mainPane.setCenter(new ScrollPane(ta));
		mainPane.setTop(gridPane);
		
		
		Scene scene = new Scene(mainPane, 450, 200);
		primaryStage.setTitle("Exercise31_01Client");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private class ButtonListener implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e){
				try{
					@SuppressWarnings("resource")
					Socket socket = new Socket(host, 8000);
					
					ObjectOutputStream toServer = 
							new ObjectOutputStream(socket.getOutputStream());
					DataInputStream fromServer = new DataInputStream(socket.getInputStream());
					
					double AnnualIntRate = Double.parseDouble(tfAnnualIntRate.getText().trim());
					double NumOfYears = Double.parseDouble(tfNumOfYears.getText().trim());
					double LoanAmount = Double.parseDouble(tfLoanAmount.getText().trim());
					
					LoanDetail ld = 
							new LoanDetail(AnnualIntRate, NumOfYears, LoanAmount);
					toServer.writeObject(ld);
					 
					
					double monthlyPayment = fromServer.readDouble();
					
					ta.appendText("Annual Interesting Rate: " + AnnualIntRate + '\n');
					ta.appendText("Number Of Years: " + NumOfYears + '\n');
					ta.appendText("Loan Amount: " + LoanAmount + '\n');
					ta.appendText("Monthly Payment: " + monthlyPayment + '\n');
					ta.appendText("Total Payment: " + monthlyPayment * NumOfYears * 12 + '\n');
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}
	}
	public static void main(String[] args){
		Application.launch(args);
	}
}
