package JavaFX.basic.Intermediate;

import Practical_Code.JavaFX.Person;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/10/2016.
 */
public class Property extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Person omda = new Person();
        omda.firstnameProperty().setValue("OMDA");
        //Set an action when a property value changing [So The Value of FirstNameProperty Must change so that this will call]
        omda.firstnameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Name Changed to  = "+newValue);
            System.out.println("firstnameProperty() => "+omda.firstnameProperty());
            System.out.println("getFirstName => "+omda.getFirstname());
        });

        Button submit = new Button("Submit");
        submit.setOnAction(event -> {
            omda.setFirstname("Omdaelmasry");
            /*This means when the data of Property Change it will work an another Action*/
        });


        StackPane l = new StackPane();
        Scene scene = new Scene(l,200,100);
        l.getChildren().addAll(submit);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){launch(args);}
}
