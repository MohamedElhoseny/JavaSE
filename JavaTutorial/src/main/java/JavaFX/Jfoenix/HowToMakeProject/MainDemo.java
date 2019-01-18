package JavaFX.Jfoenix.HowToMakeProject;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyphLoader;

import JavaFX.Jfoenix.HowToMakeProject.gui.main.MainController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDemo extends Application
{
    @FXMLViewFlowContext private ViewFlowContext flowContext;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
        //loading SVGGlyphLoader
        new Thread(()->{
            try {
                SVGGlyphLoader.loadGlyphsFont(MainDemo.class.getResourceAsStream("/resources/fonts/icomoon.svg"),"icomoon.svg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Flow flow = new Flow(MainController.class);
		DefaultFlowContainer container = new DefaultFlowContainer();
		flowContext = new ViewFlowContext();
		flowContext.register("Stage", stage);  //Stage => Key  stage => Value   [getRegisteredObject(key)]
		flow.createHandler(flowContext);  //create flowHandler le stage
        flow.start(container);

		JFXDecorator decorator = new JFXDecorator(stage,container.getView());  //container.getView()  btrg3 el layout object
		decorator.setCustomMaximize(true);
		Scene scene = new Scene(decorator, 1000, 500);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
		stage.setMinWidth(700);
		stage.setMinHeight(800);
		stage.setScene(scene);
		stage.show();
	}

}