package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class Dialogs extends Application
{
    //Note if i want to create a new GUI we create new stage , if i want to change content of GUI can change Scene
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        HBox layout = new HBox(50);
        Button db = new Button("Show DialogBox");
        Button cb = new Button("Show ConfirmBox");
        layout.getChildren().addAll(db,cb);

        db.setOnAction(event -> DialogBox.Display());     //Perfect Static method
        cb.setOnAction(event -> {
            Boolean answer = ConfirmBox.Display();
            System.out.println("returned => "+answer);
        });

        Scene scene = new Scene(layout,400,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("OptionPanes");
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
