package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXProgressBar;

import io.datafx.controller.FXMLController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Duration;

@FXMLController(value = "/resources/fxml/ui/ProgressBar.fxml", title = "Material Design Example")
public class ProgressBarController implements Initializable{

	@FXML
	private JFXProgressBar progress1;
	@FXML
	private JFXProgressBar progress2;

	public void initialize(URL location, ResourceBundle resources) {
		Timeline task = new Timeline(
							new KeyFrame(
									Duration.ZERO,
									new KeyValue(progress1.progressProperty(), 0),
									new KeyValue(progress2.progressProperty(), 0)),
							new KeyFrame(
									Duration.seconds(2),
									new KeyValue(progress1.progressProperty(), 1),
									new KeyValue(progress2.progressProperty(), 1)));
		task.setCycleCount(Timeline.INDEFINITE);
		task.play();
	}

}
