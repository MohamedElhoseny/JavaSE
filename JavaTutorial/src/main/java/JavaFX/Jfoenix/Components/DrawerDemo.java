package JavaFX.Jfoenix.Components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DrawerDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

        //buttons
		FlowPane content = new FlowPane();

		JFXButton leftButton = new JFXButton("LEFT");
		JFXButton topButton = new JFXButton("TOP");
		JFXButton rightButton = new JFXButton("RIGHT");
		JFXButton bottomButton = new JFXButton("BOTTOM");

		content.getChildren().addAll(leftButton, topButton, rightButton, bottomButton);
		content.setMaxSize(200, 200);
		/* Keys used*/
		 /*  JFXDrawer have setSidePane method , JFXDrawersStack have Toggle method   */


		JFXDrawer leftDrawer = new JFXDrawer();
		StackPane leftDrawerPane = new StackPane();

		leftDrawer.setSidePane(leftDrawerPane);
		leftDrawer.setDefaultDrawerSize(150);

		leftDrawer.setOverLayVisible(true);   //kda lma ados 3la ay mkan tane hy5tfe el drawer
		leftDrawer.setResizableOnDrag(true);
//		leftDrawer.setContent(content);

         //adding components to drawer
        leftDrawerPane.getStyleClass().add("red-400");
        leftDrawerPane.getChildren().add(new JFXButton("Left Content"));

		JFXDrawersStack drawersStack = new JFXDrawersStack();
		drawersStack.setContent(content);
		
		leftDrawer.setId("LEFT");

		
		leftButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			drawersStack.toggle(leftDrawer);
		});

		/*bottomButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			drawersStack.toggle(bottomDrawer);
		});		
		rightButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			drawersStack.toggle(rightDrawer);
		});
		topButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			drawersStack.toggle(topDrawer);
		});*/
		
		
		final Scene scene = new Scene(drawersStack, 800, 800);  //a7aaaaaa
		scene.getStylesheets().add(DrawerDemo.class.getResource("/resources/css/jfoenix-components.css").toExternalForm());
		scene.getStylesheets().add(DrawerDemo.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());

		primaryStage.setTitle("JFX Drawer Demo");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();		
		
	}

	public static void main(String[] args) { launch(args); }
	

}
