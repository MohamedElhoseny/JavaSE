package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;

import io.datafx.controller.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

@FXMLController(value = "/resources/fxml/ui/Pickers.fxml" , title = "Material Design Example")
public class PickersController implements Initializable{

	@FXML private StackPane root;
	@FXML private JFXDatePicker dateOverlay;
	@FXML private JFXDatePicker timeOverlay;
	
	public void initialize(URL location, ResourceBundle resources){
		dateOverlay.setDialogParent(root);
		timeOverlay.setDialogParent(root);
	}
}
