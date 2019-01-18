package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class First_Program extends Application
{
    private Button login;
    @Override
    public void start(Stage window)  //stage
    {
        FlowPane layout = new FlowPane();  //Parent which hold Components
        login = new Button("Log in");       //simple component
        layout.getChildren().add(login);     //add a simple component to form
        Scene scene = new Scene(layout,200,200);    //scene
        window.setScene(scene);     //add this scene to window
        window.show();         //visible the window
    }

    public static void main(String[] args){ launch(args);}
}
