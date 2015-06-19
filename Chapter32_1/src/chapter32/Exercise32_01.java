package chapter32;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.sql.*;
 

@SuppressWarnings("restriction")
public class Exercise32_01 extends Application {

	private Statement stmt;
	private Label lblStatus = new Label();
	private TextField tfID = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfFirstName = new TextField();
	private TextField tfMI = new TextField();
	private TextField tfAddress = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfTelephone = new TextField();
	
	//private TextField tfSSN = new TextField();
	
	public void start(Stage primaryStage){
		initializeDB();
		
		Button btView = new Button("View");
		Button btInsert = new Button("Insert");
		Button btUpdate = new Button("Update");
		Button btClear = new Button("Clear");
		HBox hBox1 = new HBox(2);
		HBox hBox2 = new HBox(6);
		HBox hBox3 = new HBox(2);
		HBox hBox4 = new HBox(4);
		HBox hBox5 = new HBox(2);
		HBox hBox6 = new HBox(4);
		
		hBox1.getChildren().addAll(new Label("ID"), tfID);
		hBox2.getChildren().addAll(new Label("Last Name"), tfLastName,
				new Label("First Name"), tfFirstName, new Label("MI"), tfMI);
		hBox3.getChildren().addAll(new Label("Address"), tfAddress);
		hBox4.getChildren().addAll(new Label("City"), tfCity,
				new Label("State"), tfState);
		hBox5.getChildren().addAll(new Label("Telephone"), tfTelephone);
		hBox6.getChildren().addAll(btView, btInsert, btUpdate, btClear);
		hBox6.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox(15);
		vBox.getChildren().addAll(lblStatus, hBox1, hBox2, hBox3, hBox4, hBox5, hBox6 );
		
		tfID.setPrefColumnCount(20);
		tfAddress.setPrefColumnCount(20);
		tfTelephone.setPrefColumnCount(20);
		tfLastName.setPrefColumnCount(15);
		tfFirstName.setPrefColumnCount(15);
		tfAddress.setPrefColumnCount(15);
		tfMI.setPrefColumnCount(4);
		tfCity.setPrefColumnCount(20);
		tfState.setPrefColumnCount(20);
		btView.setOnAction(e -> startView());
		btInsert.setOnAction(e -> startInsert());
		//btUpdate.setOnAction(e -> startUpdate());
		btClear.setOnAction(e -> startClear());
		
		Scene scene = new Scene(vBox, 600, 500);
		primaryStage.setTitle("ExtraExercise32_01");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void initializeDB(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/javabook", "lizard2", "lizard");
			System.out.println("Database connected");
			
			stmt = connection.createStatement();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void startView(){
		String id = tfID.getText();
		
		try{
			String queryString = "SELECT * FROM Staff " + "WHERE Staff.id = '" + id + "';";
			
			ResultSet rset = stmt.executeQuery(queryString);
			
			if(rset.next()){
				 String iD = rset.getString(1);
				 String lastName = rset.getString(2);
				 String firstName = rset.getString(3);
				 String mi = rset.getString(4);
				 String address = rset.getString(5);
				 String city = rset.getString(6);
				 String state = rset.getString(7);
				 String telephone = rset.getString(8);
				// String email = rset.getString(9);
				 
				 lblStatus.setText(iD + "has detail: " + lastName + " "
						 + firstName + " " + mi + " " + address + " " + 
						 city + " " + state + " " + telephone
						  );
				 
			}else{
				 
				lblStatus.setText("Not found");
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	private void startInsert(){
		String id = tfID.getText();
		String lastName1 = tfLastName.getText();
		String firstName1 = tfFirstName.getText();
		String mi1 = tfMI.getText();
		String address = tfAddress.getText();
		String city1 = tfCity.getText();
		String state1 = tfState.getText();
		String telephone1 = tfTelephone.getText();
		String nothing = "Unused";
		
		try{
			String queryString = "INSERT INTO staff(id, lastName, firstName, mi, address, city, state, telephone, email)"
					+ "VALUES('" + id +"', '" + lastName1 +"', '" + firstName1 + "', '" + mi1 + "' , '" + address + "',  '" + city1 + "', '" + state1 + "', '" + telephone1 +"', '" + nothing + "');";
			
		  stmt.executeUpdate(queryString);
			
			
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	private void startClear(){
		tfID.clear();
		tfLastName.clear();
		tfFirstName.clear();
		tfMI.clear();
		tfAddress.clear();
		tfCity.clear();
		tfState.clear();
		tfTelephone.clear();
		 
	}
	public static void main(String[] args){
		Application.launch(args);
	}
}
