package Practical_Code.JavaFX.Jfoenix.JfoenixFlow.LayersController;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

@FXMLController(value = "../LayersDesign/Main.fxml")
public class MainController implements Initializable {
	@FXMLViewFlowContext
	private ViewFlowContext context;

	private Flow flow;
	private FlowHandler flowHandler;

	@FXML
	private JFXButton btn1;
	@FXML
	Pane content;
	@FXML
	HBox header;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		context = new ViewFlowContext();
		flow = new Flow(Scene1Controller.class);
		flowHandler = flow.createHandler(context);

		btn1.setOnMouseClicked(event -> {
			try {
				content.getChildren().add(flowHandler.start());
			} catch (FlowException e) {
				e.printStackTrace();
			}
		});
	}
}
