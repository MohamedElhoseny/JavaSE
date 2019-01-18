package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class Scene_Switching extends Application
{
    private Scene scene1;
    private Scene scene2;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Button b1 = new Button("Scene 1");
        Button b2 = new Button("Scene 2");



        //scene1
        StackPane layout = new StackPane(b2);
        scene1 = new Scene(layout,400,200);
        b2.setOnAction(event -> primaryStage.setScene(scene2));

        //scene2
        HBox Layout = new HBox(20);
        Layout.getChildren().add(b1);
        scene2 = new Scene(Layout,600,300);
        b1.setOnAction(event -> primaryStage.setScene(scene1));




        //set default scene
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switch");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
