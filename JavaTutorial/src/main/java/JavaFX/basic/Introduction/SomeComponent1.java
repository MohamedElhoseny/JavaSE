package JavaFX.basic.Introduction;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class SomeComponent1 extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane layout = new BorderPane();
        HBox top = new HBox(5);
        VBox left = new VBox(5);
        VBox centre = new VBox(5);
        HBox bottom = new HBox(5);
        VBox right = new VBox(5);
        top.setPadding(new Insets(3,3,3,3));
        left.setPadding(new Insets(8,5,5,5));
        layout.setTop(top);
        layout.setLeft(left);
        layout.setCenter(centre);
        layout.setBottom(bottom);
        layout.setRight(right);


        /*CheckBox*/
        CheckBox c1 = new CheckBox("JavaSE");
        CheckBox c2 = new CheckBox("JavaFx");
        Button Checkbox = new Button("Select");
        Label chbox = new Label("");
        Checkbox.setOnAction(event -> {
            if (c1.isSelected())
                chbox.setText(c1.getText()+" Selected !");
            if (c2.isSelected())
                chbox.setText(c2.getText()+" Selected !");
        });
        top.getChildren().addAll(c1,c2,Checkbox,chbox);

        /*Choicebox*/
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Java","JavaSE","JavaFX","JavaEE");
        choiceBox.setValue("Java");
        choiceBox.setOnAction(event -> {
            System.out.println(choiceBox.getValue());
        });
        top.getChildren().add(choiceBox);

        /*ComboBox*/
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Java","JavaSE","JavaFX","JavaEE");
        combo.setValue("Java");
        combo.setOnAction(event -> {
            String x = combo.getValue();
            System.out.println(x);
        });
        top.getChildren().add(combo);

        /*ListView*/
        ListView<String> list = new ListView<>();
        list.getItems().addAll("Java","JavaSE","JavaFX","JavaEE");
        Button l = new Button("Submit");
        l.setOnAction(event -> {

            //to select which model :
            //list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);   [ single model is used by default ]
            list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

               //leh lazem ageb el getselectionModel l2n fe no3en mn selection hna Single or Multi
            //  String x = list.getSelectionModel().getSelectedItem();   for single
            ObservableList<String> get = list.getSelectionModel().getSelectedItems();
            for (String e:get) {
                System.out.println(e+" is Selected");
            }
        });
            /*Invocation Handler in getSelectionModel()  then can get item value or index*/
        list.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("InvocationHandler by me now : selected => "+newValue);
        }));
        left.getChildren().addAll(list,l);


        /*TreeView*/
        TreeItem<String> r1 = new TreeItem<>("Java");
        TreeItem<String> item1 = new TreeItem<>("JavaSE");
        TreeItem<String> item2 = new TreeItem<>("JavaFX");
        r1.setExpanded(true);
        r1.getChildren().addAll(item1,item2);

        TreeItem<String> colour = new TreeItem<>("Colors");
        TreeItem<String> s1 = new TreeItem<>("Blue");
        TreeItem<String> s2 = new TreeItem<>("White");
        TreeItem<String> s3 = new TreeItem<>("Yellow");
        colour.setExpanded(true);
        colour.getChildren().addAll(s1,s2,s3);

        TreeItem<String> root = new TreeItem<>("root");
        root.getChildren().addAll(r1,colour);
        root.setExpanded(true);

        TreeView<String> tree = new TreeView<>(root);    //dah lazem yst2bl node wa7da feha kolo
        tree.setShowRoot(false);     //3mlnaha hide 3shan el nodes 2le gwaha tb2a kol wa7d lw7dha
                                                        //Invocation handler
        tree.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(newValue.getValue());
        }));
        right.getChildren().add(tree);



        /* How to Create Observable list*/
        ObservableList<Object> ex = FXCollections.observableArrayList();

        Scene scene = new Scene(layout,700,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Components Preview");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}