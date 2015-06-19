package chapter14;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

@SuppressWarnings("restriction")
public class DisplayThreeCards extends Application{
	public void start(Stage primaryStage){
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5, 5, 5, 5));
		for(int i = 1; i <= 3; i++){
			
			int r = (int) ((Math.random() * 52) + 1);
			Image image = new Image("image/" + r + ".png" );
			pane.getChildren().add(new ImageView(image));
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Three Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}

}
