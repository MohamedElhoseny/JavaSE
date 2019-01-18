package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class EmbeddedLayouts extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        HBox h = new HBox(10);
        VBox v = new VBox(10);
        BorderPane layout = new BorderPane();
        layout.setTop(h);
        layout.setLeft(v);


        h.getChildren().addAll(new Button("File"),new Button("Edit"),new Button("View"));
        v.getChildren().addAll(new Button("File"),new Button("Edit"),new Button("View"));


        Scene scene = new Scene(layout,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Embedded Layout");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
