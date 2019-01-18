package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.validation.ValidationFacade;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.util.VetoException;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@FXMLController(value = "/resources/fxml/ui/Combobox.fxml" , title = "Material Design Example")
public class ComboBoxController implements Initializable
{
	
	@FXML private JFXComboBox<String> jfxComboBox;
	@FXML private JFXComboBox<String> jfxEditableComboBox;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		
		jfxComboBox.focusedProperty().addListener((o, oldVal, newVal) -> {
			if (!newVal) {
				ValidationFacade.validate(jfxComboBox);
			}
		});
		
		ChangeListener<? super Boolean> comboBoxFocus = (o, oldVal, newVal) -> {
			if (!newVal) {
				ValidationFacade.validate(jfxEditableComboBox);
			}
		};		
		jfxEditableComboBox.focusedProperty().addListener(comboBoxFocus);  /* deh el changelistener*/
		jfxEditableComboBox.getJFXEditor().focusedProperty().addListener(comboBoxFocus);				
	}


	
	
}
