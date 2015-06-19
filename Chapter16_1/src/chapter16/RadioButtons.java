package chapter16;

import javafx.scene.paint.Color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

@SuppressWarnings("restriction")
public class RadioButtons extends ButtonDemo{
	
	protected BorderPane getPane(){
		BorderPane pane = super.getPane();
		
		HBox paneForRadioButtons = new HBox(20);
		paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
		paneForRadioButtons.setStyle("-fx-border-color: green");
		paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");
		
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		
		paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		pane.setTop(paneForRadioButtons);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		rbRed.setOnAction(e -> {
			if(rbRed.isSelected()){
				text.setFill(Color.RED);
			}
		});
		
		rbYellow.setOnAction(e -> {
			if(rbYellow.isSelected()){
				text.setFill(Color.YELLOW);
			}
		});
		
		rbBlack.setOnAction(e -> {
			if(rbBlack.isSelected()){
				text.setFill(Color.BLACK);
			}
		});
		
		rbOrange.setOnAction(e -> {
			if(rbOrange.isSelected()){
				text.setFill(Color.ORANGE);
			}
		});
		
		rbGreen.setOnAction(e -> {
			if(rbGreen.isSelected()){
				text.setFill(Color.GREEN);
			}
		});
		
		return pane;
		
	}

	public static void main(String[] args){
		Application.launch(args);
	}
}
