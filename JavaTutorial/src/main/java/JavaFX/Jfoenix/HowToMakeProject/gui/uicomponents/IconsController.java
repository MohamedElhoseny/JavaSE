package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;

import io.datafx.controller.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;

@FXMLController(value = "/resources/fxml/ui/Icons.fxml", title = "Material Design Example")
public class IconsController implements Initializable{

	@FXML
	private JFXHamburger burger1;
	@FXML
	private JFXHamburger burger2;
	@FXML
	private JFXHamburger burger3;
	@FXML
	private JFXHamburger burger4;

	@FXML
	private JFXBadge badge1;
	
	@FXML private StackPane root;
	@FXML private JFXSnackbar snackbar;
	int count=0;
	
	
	public void initialize(URL location, ResourceBundle resources) {
		
		bindAction(burger1);
		bindAction(burger2);
		bindAction(burger3);
		bindAction(burger4);

		snackbar.registerSnackbarContainer(root);
		
		badge1.setOnMouseClicked((e) -> {
			int value = Integer.parseInt(badge1.getText());
			if (e.getButton() == MouseButton.PRIMARY) {
				value++;
			} else if (e.getButton() == MouseButton.SECONDARY) {
				value--;
			}
			
			if (value == 0) {
				badge1.setEnabled(false);
			} else {
				badge1.setEnabled(true);
			}
			badge1.setText(String.valueOf(value));
			
			// trigger snackbar
			if (count++%2==0){
				snackbar.fireEvent(new SnackbarEvent("Toast Message " + count));
			} else {
				snackbar.fireEvent(new SnackbarEvent("Snackbar Message "+ count,"UNDO",3000,(b)->{}));
			}
		});
	}

	private void bindAction(JFXHamburger burger) {
		burger.setOnMouseClicked((e) -> {
			burger.getAnimation().setRate(burger.getAnimation().getRate() * -1);
			burger.getAnimation().play();
		});
	}

}
