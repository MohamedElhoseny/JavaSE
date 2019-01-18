package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;



import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController(value = "/resources/fxml/ui/TextField.fxml", title = "Material Design Example")
public class TextFieldController implements Initializable {

	@FXML
	private JFXTextField validatedText;
	
	@FXML private JFXPasswordField validatedPassowrd;
	@FXML private JFXTextArea jfxTextArea;


	public void initialize(URL url, ResourceBundle resourceBundle) {
		validatedText.focusedProperty().addListener((o, oldVal, newVal) -> {
			if (!newVal) validatedText.validate();
		});
		validatedPassowrd.focusedProperty().addListener((o, oldVal, newVal) -> {
			if (!newVal) validatedPassowrd.validate();
		});
		jfxTextArea.focusedProperty().addListener((o, oldVal, newVal) -> {
			if (!newVal) jfxTextArea.validate();
		});
	}

}
