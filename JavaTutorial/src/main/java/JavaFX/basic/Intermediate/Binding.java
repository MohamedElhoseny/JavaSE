package JavaFX.basic.Intermediate;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/11/2016.
 */
public class Binding extends Application
{
    public void start(Stage primaryStage) throws Exception
    {
        IntegerProperty x = new SimpleIntegerProperty(2); //2 is intial value
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));     //bind

        System.out.println("x = "+x.getValue());
        System.out.println("y = "+y.getValue());

        Button submit = new Button("Submit");
        submit.setOnAction(event -> {
            x.setValue(4);
            System.out.println("x = "+x.getValue());
            System.out.println("y = "+y.getValue());  /* What result here ?*/
        });



        //Second Example :
        TextField input = new TextField();
        Label in = new Label("Waiting to Search ..");

        /*I want to bind label text with textfield text*/
        in.textProperty().bind(input.textProperty());             //many many many property have  eg.effectProperty

        VBox l = new VBox();
        Scene scene = new Scene(l,200,100);
        l.getChildren().addAll(submit,input,in);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){launch(args);}
}
