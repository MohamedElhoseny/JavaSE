package Practical_Code.JavaFX.JanimateCss.sample;

import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 10/1/2016.
 */
public class main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        JFXDecorator frame = new JFXDecorator(primaryStage,root);

        Scene scene = new Scene(frame);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){ launch(args);}
}
