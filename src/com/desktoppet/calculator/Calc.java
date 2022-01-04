package com.desktoppet.calculator;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/*
 * Description: Calculator function
 *
 * @author Bingming Zhang
 */


public class Calc extends Application {

	//textField is an attribute so it can be referenced outside of the start(...) method
	TextField textField;
	String operator_str = "+-*/!%^=";
	String digit_str = "7894561230.";
	String value = "0";
	String fulltext="";
	boolean HaveTextAfterEqu=false;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		//top
		textField = new TextField();
		textField.setPrefHeight(50);
		textField.setFont(Font.font(20));
		root.setTop(textField);
		//String operator_str = "+-*/";
		ButtonHandler handler = new ButtonHandler(primaryStage);

		//left
		GridPane Loperator = new GridPane();
		Loperator.setAlignment(Pos.TOP_LEFT);
		int x = 0 , y=0;
		for(int i=0;i<operator_str.length();i++) {
			Button current = new Button(operator_str.substring(i,i+1));
			current.setMinSize(50,50);
			current.prefHeightProperty().bind(Bindings.divide(primaryStage.heightProperty(),15.0));
			current.prefWidthProperty().bind(Bindings.divide(primaryStage.widthProperty(),15.0));
			current.setFont(Font.font(20));
			current.setOnAction(handler);
			Loperator.add(current,x,y);
			x ++;
			y = y + x/2;
			x=x%2;
		}

		root.setLeft(Loperator);

		//center
		GridPane digitButtonGridPane = new GridPane();
		digitButtonGridPane.setAlignment(Pos.TOP_LEFT);
		x=y=0;
		for(int i=0;i<digit_str.length();i++)
		{
			Button current = new Button(digit_str.substring(i, i+1));
			current.setMinSize(50,50);
			current.prefHeightProperty().bind(Bindings.divide(primaryStage.heightProperty(),15.0));
			current.prefWidthProperty().bind(Bindings.divide(primaryStage.widthProperty(),15.0));
			current.setFont(Font.font(20));
			current.setOnAction(handler);
			digitButtonGridPane.add(current, x , y );
			x ++;
			y = y + x/3;
			x=x%3;
		}
		root.setCenter(digitButtonGridPane);

		//right
		VBox rightButtonVBox = new VBox();
		rightButtonVBox.setAlignment(Pos.TOP_LEFT);
		Button exit= new Button("EXIT");
		exit.setMinSize(50, 50);
		exit.prefHeightProperty().bind(Bindings.divide(primaryStage.heightProperty(),0.25));
		exit.prefWidthProperty().bind(Bindings.divide(primaryStage.widthProperty(),10.0));
		exit.setFont(Font.font(15));
		exit.setOnAction(handler);
		rightButtonVBox.getChildren().add(exit);
		Button Clear = new Button("C");
		Clear.setMinSize(50, 50);
		Clear.prefHeightProperty().bind(Bindings.divide(primaryStage.heightProperty(),0.25));
		Clear.prefWidthProperty().bind(Bindings.divide(primaryStage.widthProperty(),10.0));
		Clear.setFont(Font.font(15));
		Clear.setOnAction(handler);
		rightButtonVBox.getChildren().add(Clear);

		root.setRight(rightButtonVBox);

		Scene scene = new Scene(root,300,250);
		primaryStage.setScene(scene);
		primaryStage.setMaxHeight(290);
		primaryStage.setMaxWidth(320);
		primaryStage.setTitle("Calculator");
		primaryStage.show();
	}

	class ButtonHandler implements EventHandler<ActionEvent> {
		private Stage stage;

		public ButtonHandler(Stage stage) {
			this.stage = stage;
		}

		@Override
		public void handle(ActionEvent e) {
			Button pressed = (Button)e.getTarget();
			String text = pressed.getText();
			if(HaveTextAfterEqu == true)
			{
				textField.setText("");
				HaveTextAfterEqu = false;
			}
			if(text.equals("="))
			{
				Comp me = new Comp();
				me.Setup(fulltext);
				try {
					double ans = me.operationCall();
					textField.setText(""+ans);
				}catch(Exception ex1)
				{
					textField.setText("ERR");
				}
				fulltext="";
				HaveTextAfterEqu = true;
			}else if(text.equals("C"))
			{
				fulltext="";
				textField.setText("");
			}else if(text.equals("EXIT")){
				stage.close();
			}
			else
			{
				fulltext = fulltext+text;
				textField.appendText(text);
			}
		}
	}

}
