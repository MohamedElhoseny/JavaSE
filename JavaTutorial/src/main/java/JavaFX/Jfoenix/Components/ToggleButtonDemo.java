package JavaFX.Jfoenix.Components;

import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXToggleNode;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ToggleButtonDemo extends Application {

	private VBox pane;
    boolean wifi_on = false;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		pane = new VBox();
		pane.setSpacing(30);
		pane.setStyle("-fx-background-color:#EEE; -fx-padding: 40;");
		
		ToggleButton button = new ToggleButton("JavaFx Toggle");  //simple of JAVAFX  not used
		pane.getChildren().add(button);


		JFXToggleButton toggleButton = new JFXToggleButton();   //commently used
		toggleButton.setText("New Skin");
		pane.getChildren().add(toggleButton);



        JFXToggleButton wifi = new JFXToggleButton();
        wifi.setText("Wifi");
        pane.getChildren().add(wifi);


        wifi.setOnAction(event -> {
            if (wifi.isSelected())
                wifi_on = true;
            else
                wifi_on = false;

            System.out.println(wifi_on);
        });



		
		JFXToggleNode node = new JFXToggleNode();		 //this is ToggleNode  not ToggleButton
		FontAwesomeIconView value = new FontAwesomeIconView(FontAwesomeIcon.POWER_OFF);
		value.setGlyphSize(10);
		//value.setPadding(new Insets(10));
		node.setGraphic(value);
		
		pane.getChildren().add(node);
		

		final Scene scene = new Scene(pane, 600, 400, Color.valueOf("#EEE"));
		stage.setTitle("JFX Toggle Button Demo ");
		scene.getStylesheets().add(ToggleButtonDemo.class.getResource("/resources/css/jfoenix-components.css").toExternalForm());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		

	}
	public static void main(String[] args) { launch(args); }

}
