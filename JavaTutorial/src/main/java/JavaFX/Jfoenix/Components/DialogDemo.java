package JavaFX.Jfoenix.Components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/20/2016.
 */
public class DialogDemo extends Application
{
    /* msh 3wza tesht8l m3aya  t2rebn lazem tsht8l 3la pane m3molo animation*/
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane layout = new BorderPane();

        //JFXDialog Container
        StackPane l = new StackPane();
        //JDXDialog Container Content
        Label msg = new Label("Hello , this is a dialog , how are you , mmmmmmmmmmmmmmmmmmmmmmm , hello best wishes to you ");
        l.getChildren().add(msg);

        JFXDialog dialog = new JFXDialog();

        /////////////////////////////////
        JFXButton btn = new JFXButton("Click Me");
        btn.setOnMouseClicked(event -> {
            dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
            dialog.show(l);
        });

        layout.setCenter(btn);
        Scene scene = new Scene(layout,700,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
