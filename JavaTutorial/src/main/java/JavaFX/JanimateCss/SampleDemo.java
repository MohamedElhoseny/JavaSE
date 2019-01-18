package JavaFX.JanimateCss;

import Font.FontLoader;
import com.jfoenix.controls.JFXDecorator;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleDemo extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //FontLoader (1)
        FontLoader.loadFont("http://fonts.googleapis.com/css?family=Francois+One");  //font not found
        FontLoader.loadFont("http://fonts.googleapis.com/css?family=Elephant");   //loaded
 
      //Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

        ViewFlowContext context = new ViewFlowContext();
        DefaultFlowContainer container = new DefaultFlowContainer();
        Flow flow = new Flow(SampleController.class);
        flow.createHandler(context).start(container);

        JFXDecorator view = new JFXDecorator(primaryStage,container.getView());
        view.setCustomMaximize(true);

        Scene scene = new Scene(view);

        scene.getStylesheets().add(getClass().getResource("SampleResources/styledemo.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-design.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("JanimateCss Library");
        primaryStage.show();
    }

    public static void main(String[] args){ launch(args);}
}
