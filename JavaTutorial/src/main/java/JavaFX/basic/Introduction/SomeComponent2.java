package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/10/2016.
 */
public class SomeComponent2 extends Application
{
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane layout = new BorderPane();

        /* MenuBar */
        MenuBar thebar = new MenuBar();
        Menu file = new Menu("File");
        Menu Edit = new Menu("Edit");
        Menu help = new Menu("Help"); //CheckMenuItem
        Menu lvl  = new Menu("Level");

        MenuItem f1 = new MenuItem("New Project") , f2 = new MenuItem("Open Project");
        file.getItems().addAll(f1,f2);

        MenuItem e1 = new MenuItem("Copy") , e2 = new MenuItem("Cut") , e3 = new MenuItem("Paste");
        e3.setDisable(true); //this is a condition for menu item as it must be first Copy or Cut
        Edit.getItems().addAll(e1,e2,e3);

        CheckMenuItem h1 = new CheckMenuItem("Show Line Number") , h2 = new CheckMenuItem("Auto Save");
        h2.setSelected(true); //Enable by default
        //handle action
        h1.setOnAction(event -> {
            //3nde a7tmalen
            if (h1.isSelected())
                System.out.println("Line Number is enabled");
             else
                System.out.println("Line Number is Disabled");
        });
         h2.setOnAction(event -> {
             if (h2.isSelected())
                 System.out.println("AutoSave enabled");
             else
                 System.out.println("AutoSave Disabled");
         });
        //Adding
        help.getItems().addAll(h1,h2);

        f1.setOnAction(event -> {
            System.out.println("New project GUI opened");
        });

        RadioMenuItem l1 = new RadioMenuItem("Easy"),l2 = new RadioMenuItem("Medium"), l3 = new RadioMenuItem("Hard");
        ToggleGroup lvlgroup = new ToggleGroup();
        l1.setToggleGroup(lvlgroup);
        l2.setToggleGroup(lvlgroup);
        l3.setToggleGroup(lvlgroup);
        lvl.getItems().addAll(l1,l2,l3);


        thebar.getMenus().addAll(file,Edit,lvl,help);
        layout.setTop(thebar);




        Scene scene = new Scene(layout,400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
