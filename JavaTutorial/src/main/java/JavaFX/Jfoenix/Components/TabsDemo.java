package JavaFX.Jfoenix.Components;

import java.math.BigInteger;
import java.security.SecureRandom;

import com.jfoenix.animation.JFXNodesAnimation;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import javafx.util.Duration;

public class TabsDemo extends Application
{

	private String msg = "Tab 0";

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Tabs");

		HBox root = new HBox();
		Scene scene = new Scene(root, 700, 250);

		JFXTabPane tabPane = new JFXTabPane();

		Tab tab = new Tab();
		tab.setText("Home");
        StackPane testpane = new StackPane();
        testpane.getChildren().add(new Label("Home label"));
        testpane.setStyle("-fx-background-color: greenyellow");
		tab.setContent(testpane); /*Content of tab*/

		Tab tab1 = new Tab();
        tab1.setText("Home2");
        StackPane testpane2 = new StackPane();
        testpane2.getChildren().add(new Label("Next label"));
        testpane2.setStyle("-fx-background-color: red");
        tab1.setContent(testpane2);

        tabPane.getTabs().addAll(tab,tab1);
        tabPane.setPrefSize(300, 200);
        tabPane.setMaxWidth(500);

        //set default tab
		SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
		selectionModel.select(0);




		HBox hbox = new HBox();
		hbox.getChildren().addAll(tabPane);
		hbox.setSpacing(50);
		hbox.setAlignment(Pos.CENTER);
		hbox.setStyle("-fx-padding:20");
		root.getChildren().addAll(hbox);
		scene.getStylesheets().add(TabsDemo.class.getResource("/resources/css/jfoenix-components.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("JFX Tabs Demo");
	}


    public static void main(String[] args) {
        Application.launch(args);
    }
}
