package chapter15;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

@SuppressWarnings({ "unused", "restriction" })
public class PickFourCards extends Application {

	GridPane pane = new GridPane();
	public void start(Stage primaryStage){
		
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		Button btRefresh = new Button("Refresh");
		RefreshHandlerClass handler1 = new RefreshHandlerClass();
		btRefresh.setOnAction(handler1);
		
		pane.add(btRefresh, 2, 1);
		
    for(int i = 0; i < 4; i++){
			
			int r = (int) ((Math.random() * 52) + 1);
			Image image = new Image("image/" + r + ".png" );
			pane.add(new ImageView(image), i, 0 );
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Four Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	class RefreshHandlerClass implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			for(int i = 0; i < 4; i++){
				
				int r = (int) ((Math.random() * 52) + 1);
				Image image = new Image("image/" + r + ".png" );
				pane.add(new ImageView(image), i, 0 );
			}
		}
		
	}
	public static void main(String[] args){
		Application.launch(args);
	}
	
	
}


