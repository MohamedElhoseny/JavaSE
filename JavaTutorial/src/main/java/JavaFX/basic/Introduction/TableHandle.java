package JavaFX.basic.Introduction;
import Practical_Code.JavaFX.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableHandle extends Application
{
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox layout = new VBox(5);

        //Product Column
        TableColumn<Product,String> item = new TableColumn<>("product");
        item.setMinWidth(100);
        item.setCellValueFactory(new PropertyValueFactory<>("name"));   //Note if getter function doent written nothing get
        //Price Column
        TableColumn<Product,Double> price = new TableColumn<>("Price");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        //quantity Column
        TableColumn<Product,Double> quantity = new TableColumn<>("Quantity");
        quantity.setMinWidth(100);
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Prepare Table data in ObservableList
        ObservableList<Product> list = FXCollections.observableArrayList();
        list.add(new Product("Pepsi",8.5,12));
        list.add(new Product("Pizza",12.5,5));
        list.add(new Product("Chocolate",4,40));
        list.add(new Product("Cikes",12.5,5));

        //Create Table
        TableView<Product> table = new TableView<>(list);
        table.getColumns().addAll(item,price,quantity);

        //Add table to layout
        layout.getChildren().add(table);

        HBox horiz = new HBox(10);
        horiz.setPadding(new Insets(10,10,10,10));
        TextField pn = new TextField();
        pn.setPromptText("Product Name");
        TextField pp = new TextField();
        pp.setPromptText("Product Price");
        TextField pq = new TextField();
        pq.setPromptText("Product Quatity");

        Button add = new Button("Add");
        add.setOnAction(event -> {
            String prodname = pn.getText();
            double prodprice = Double.parseDouble(pp.getText());
            int prodquantity = Integer.parseInt(pq.getText());
            list.add(new Product(prodname,prodprice,prodquantity));   //handle wrong input before it
            pn.clear(); pp.clear();  pq.clear();
        });
        Button delete = new Button("Delete");
        delete.setOnAction(event -> {
          /* dah 2le ana kont 3wz a3rfo 2ne mynf3sh aktb data bta3t product w agebh w adeleto
          * bs ynf3 ast5dm select w adelete*/
            ObservableList<Product> allproduct = table.getItems();
            ObservableList<Product> deletedone = table.getSelectionModel().getSelectedItems();
            deletedone.forEach(allproduct::remove);   //Tre2a gdeda bms7 mn allproduct 2le a5trto  7lwaaaaa gdn

        });

        //Add Hbox im the layout
        horiz.getChildren().addAll(pn,pp,pq,add,delete);
        layout.getChildren().add(horiz);

        Scene scene = new Scene(layout,600,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
