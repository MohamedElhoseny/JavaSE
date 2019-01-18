package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class GridLayout extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {  //default Steps : Create layout , add component to layout , create Scene with layout , set Stage Scene

        GridPane layout = new GridPane();

        //properties
        layout.setPadding(new Insets(10,10,10,10));    //insets => ab3adat  (top,left,right,bottom)

        //b7dd behm el item yb2o 2ryben horizontal 2d 2eh w vertical 2d 2eh
        layout.setHgap(8);
        layout.setVgap(10);

        //name
        Label name = new Label("UserName : ");
        GridPane.setConstraints(name,0,0);   //setConstraints(Node e, int coloumn ,int row)
        //name input
        TextField name_input = new TextField();
        name_input.setPromptText("Your username");
        GridPane.setConstraints(name_input,1,0);

        //password
        Label pass = new Label("Password : ");
        GridPane.setConstraints(pass,0,1);
        //password input
        PasswordField pass_input = new PasswordField();
        pass_input.setPromptText("Your password");
        GridPane.setConstraints(pass_input,1,1);

        //Confirm
        Button ok = new Button("Log in");
        GridPane.setConstraints(ok,1,2);

        layout.getChildren().addAll(name,name_input,pass,pass_input,ok);

        Scene scene = new Scene(layout,400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Log in ..");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}