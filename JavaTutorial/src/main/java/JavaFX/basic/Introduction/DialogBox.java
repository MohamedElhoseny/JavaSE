package JavaFX.basic.Introduction;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class DialogBox
{
    //To Make it as a blocker Dialog  whick can select Parent Stage until this Close
    public static void Display()
    {
        Stage alertwindow = new Stage();
        HBox layout = new HBox(50);
        Label msg = new Label("This is a Dialog Box !");

        layout.getChildren().add(msg);

        Scene scene = new Scene(layout,200,200);

        alertwindow.setTitle("Alert Dialog");
        alertwindow.setScene(scene);
        //alertwindow.show();
        /* blocker */
        alertwindow.initModality(Modality.APPLICATION_MODAL);
        alertwindow.showAndWait();
    }
}
