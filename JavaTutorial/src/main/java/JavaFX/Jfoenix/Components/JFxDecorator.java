package JavaFX.Jfoenix.Components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/21/2016.
 */
public class JFxDecorator extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        StackPane l = new StackPane(new JFXButton("Simple Button"));

        JFXDecorator form = new JFXDecorator(primaryStage,l);

        Scene scene = new Scene(form,500,400);
        scene.getStylesheets().add("/resources/css/jfoenix-components.css");
       // scene.getStylesheets().add("/resources/css/jfoenix-main-demo.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){launch(args);}
}
