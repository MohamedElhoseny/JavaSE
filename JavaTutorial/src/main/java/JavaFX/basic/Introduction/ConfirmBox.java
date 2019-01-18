package JavaFX.basic.Introduction;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class ConfirmBox
{
    static boolean answer;

    public static boolean Display()
    {
        Stage alertwindow = new Stage();
        HBox layout = new HBox(50);
        Label msg = new Label("Do you Want to Save Work ?");
        Button b1 = new Button("Save");
        Button b2 = new Button("Cancel");
        layout.getChildren().addAll(msg,b1,b2);

        b1.setOnAction(event -> {
            answer = true;
            alertwindow.close();
        });

        b2.setOnAction(event -> {
            answer=false;
            alertwindow.close();
        });

        Scene scene = new Scene(layout,400,50);
        alertwindow.setTitle("ConfirmBox");
        alertwindow.setScene(scene);

        /* blocker */
        alertwindow.initModality(Modality.APPLICATION_MODAL);
        alertwindow.showAndWait();

        return answer;
    }

}
