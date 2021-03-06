package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@FXMLController(value = "/resources/fxml/ui/ListView.fxml" , title = "Material Design Example")
public class ListViewController implements Initializable
{
	
	@FXML private JFXListView<?> list1;
	@FXML private JFXListView<?> list2;
	@FXML private JFXListView<?> subList;
	
	@FXML private JFXButton button3D;
	@FXML private JFXButton collapse;
	@FXML private JFXButton expand;
	
	private int counter = 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		button3D.setOnMouseClicked((e)->{
			int val = ++counter%2;
			list1.depthProperty().set(val);
			list2.depthProperty().set(val);
		});
		
		expand.setOnMouseClicked((e)->list2.expandedProperty().set(true));
		collapse.setOnMouseClicked((e)->list2.expandedProperty().set(false));
		list1.depthProperty().set(1);
	}
	
	
	
}
