package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class ClosingHandle extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    Stage window;
    @Override
    public void start(Stage primary) throws Exception
    {
        window = primary;
        Button b2 = new Button("Close");
        StackPane layout = new StackPane(b2);
        Scene scene = new Scene(layout,200,100);

        b2.setOnAction(event -> {
            event.consume();  //3shan t5leh ya5od w2to fe el work 2le 2bl close
            close_program();
        });

        /*if we click on default close button*/
        window.setOnCloseRequest(event -> {
            event.consume();   //Try to delete it then retry closing with it
            close_program();
        });


        window.setScene(scene);
        window.show();
    }

    public void close_program()
    {
        boolean x = ConfirmBox.Display();
        if (x)
        {
            window.close();
            System.out.println("Saving ..");
        }
    }
}
