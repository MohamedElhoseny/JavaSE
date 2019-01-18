package Practical_Code.JavaFX.Jfoenix.JfoenixFlow;

import Practical_Code.JavaFX.Jfoenix.JfoenixFlow.LayersController.MainController;
import com.jfoenix.controls.JFXDecorator;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Elhosany on 9/28/2016.
 */
public class MainClass extends Application
{
    @FXMLViewFlowContext private ViewFlowContext context;

    private Flow flow;
    private FlowHandler flowHandler;
    private DefaultFlowContainer container;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        context = new ViewFlowContext(); //1
        container = new DefaultFlowContainer(); //2

        //3  ay flow lazem ykon leh handler
        flow = new Flow(MainController.class);
        flowHandler = flow.createHandler(context);

        flow.start(container); //4   main flow ba start meno el container w b3d kda hst5dm el handlers 3shan azhr 7aga b3d lda

        /** Registering Objects */
        context.register("Stage", primaryStage);


        JFXDecorator frame = new JFXDecorator(primaryStage,container.getView());
        Scene scene = new Scene(frame);
        scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-design.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){ launch(args);}
}

