package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class Handling_Event extends Application implements EventHandler<ActionEvent>
{
    Button accept = new Button("Accept");
    Button refuse = new Button("refuse");
    Button nothing = new Button("nothing");

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FlowPane layout = new FlowPane();
        layout.getChildren().addAll(accept,refuse,nothing);   //forget getchildren()
        Scene scene = new Scene(layout,400,200);


        /* Three Style of Handling Events */
        accept.setOnAction(this);  //if action do in this button you will find the handle method in this class

        refuse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              System.out.println("You Click refuse");
            }
        });

        nothing.setOnAction(event -> {       //using lambda expression
            System.out.println("You Click Nothing");
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Event handler");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == accept)   //TO CHECK ANY button Clicked
        {
            System.out.println("You Click Accept !");
        }
    }
}
