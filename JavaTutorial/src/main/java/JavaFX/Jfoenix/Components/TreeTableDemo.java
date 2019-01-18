package JavaFX.Jfoenix.Components;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;


public class TreeTableDemo extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

			// Creating Columns
			JFXTreeTableColumn<User, String> deptColumn = new JFXTreeTableColumn<>("Department");
			deptColumn.setPrefWidth(150);

			JFXTreeTableColumn<User, String> empColumn = new JFXTreeTableColumn<>("Employee");
			empColumn.setPrefWidth(150);

			JFXTreeTableColumn<User, String> ageColumn = new JFXTreeTableColumn<>("Age");
			ageColumn.setPrefWidth(150);


			// data
			ObservableList<User> users = FXCollections.observableArrayList();
			users.add(new User("Computer Department", "23","CD 1"));
			users.add(new User("Sales Department", "22","Employee 1"));
			users.add(new User("Sales Department", "22","Employee 2"));
			users.add(new User("Sales Department", "25","Employee 4"));
			users.add(new User("Sales Department", "25","Employee 5"));
			users.add(new User("IT Department", "42","ID 2"));
			users.add(new User("HR Department", "22","HR 1"));
			users.add(new User("HR Department", "22","HR 2"));

			// build tree
			final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);

            //Create Table
			JFXTreeTableView<User> treeView = new JFXTreeTableView<User>(root, users);
			treeView.setShowRoot(false);
			treeView.setEditable(true);
			treeView.getColumns().setAll(deptColumn, ageColumn, empColumn);






			FlowPane main = new FlowPane();
			main.setPadding(new Insets(10));
			main.getChildren().add(treeView);


			JFXButton groupButton = new JFXButton("Group");
			groupButton.setOnAction((action)->{
				new Thread(()-> treeView.group(empColumn)).start();
			});
			main.getChildren().add(groupButton);

			JFXButton unGroupButton = new JFXButton("unGroup");
			unGroupButton.setOnAction((action)->treeView.unGroup(empColumn));
			main.getChildren().add(unGroupButton);

			JFXTextField filterField = new JFXTextField();
			main.getChildren().add(filterField);

			Label size = new Label();

			filterField.textProperty().addListener((o,oldVal,newVal)->{
				treeView.setPredicate(user -> user.getValue().age.get().contains(newVal) || user.getValue().department.get().contains(newVal) || user.getValue().userName.get().contains(newVal));
			});

			size.textProperty().bind(Bindings.createStringBinding(()->treeView.getCurrentItemsCount()+"", treeView.currentItemsCountProperty()));
			main.getChildren().add(size);

			Scene scene = new Scene(main, 475, 500);
			scene.getStylesheets().add(TreeTableDemo.class.getResource("/resources/css/jfoenix-components.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

//						ScenicView.show(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	class User extends RecursiveTreeObject<User>{
		
		StringProperty userName;
		StringProperty age;
		StringProperty department;

		public User(String department, String age, String userName) {
			this.department = new SimpleStringProperty(department) ;
			this.userName = new SimpleStringProperty(userName);
			this.age = new SimpleStringProperty(age);
		}

	}


}