package JavaFX.Jfoenix.HowToMakeProject.gui.main;

import JavaFX.Jfoenix.HowToMakeProject.datafx.AnimatedFlowContainer;
import JavaFX.Jfoenix.HowToMakeProject.gui.sidemenu.SideMenuController;
import JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents.ButtonController;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.ContainerAnimations;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

              /*dah el controller bta3 main.fxml*/
@FXMLController(value = "/resources/fxml/Main.fxml", title = "Material Design Example")
public class MainController implements Initializable {

	@FXMLViewFlowContext private ViewFlowContext context;

    private FlowHandler flowHandler;
    private FlowHandler sideMenuFlowHandler;

	@FXML private StackPane root;
	@FXML private StackPane titleBurgerContainer;
	@FXML private JFXHamburger titleBurger;
	@FXML private StackPane optionsBurger;	
	@FXML private JFXRippler optionsRippler;
	@FXML private JFXDrawer drawer;
	@FXML private JFXPopup toolbarPopup;
	@FXML private Label exit;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
    ///////////    lma aft7 w a2fl el left drawer dh el action 3la Hamburger icon   ///////////////////////
        drawer.setOverLayVisible(false);
		drawer.setOnDrawerOpening((e) -> {
			titleBurger.getAnimation().setRate(1);
			titleBurger.getAnimation().play();
		});
		drawer.setOnDrawerClosing((e) -> {
			titleBurger.getAnimation().setRate(-1);
			titleBurger.getAnimation().play();
		});
  ///////////////////////////////////////////////////////////////


		titleBurgerContainer.setOnMouseClicked((e)->{   //dh m3nah lw ana dost fe layout bta3t el container hy2fl el drawer
			if (drawer.isHidden() || drawer.isHidding())
			    drawer.open();
			else
			    drawer.close();
		});

		// init Popup 
		toolbarPopup.setPopupContainer(root);		
		toolbarPopup.setSource(optionsRippler);
		root.getChildren().remove(toolbarPopup); //hna ana 3mltlha remove 3shan a5feha
		
		optionsBurger.setOnMouseClicked((e) -> {
            toolbarPopup.show(PopupVPosition.TOP, PopupHPosition.RIGHT, -12, 15);  //aho lma ados hyzhrha
        });

		// close application
		exit.setOnMouseClicked((e) -> {
			Platform.exit();  //3shan el fx application y2fl
		});

        /*  **************** Change Scene with Animation *****************************  */

		// create the inner flow and content
		context = new ViewFlowContext();
		Flow innerFlow = new Flow(ButtonController.class);  //Means that buttons is the default view in the innerFlow
		flowHandler = innerFlow.createHandler(context);
		context.register("ContentFlowHandler", flowHandler);  //h7tago fe sidemenu
		context.register("ContentFlow", innerFlow);

        AnimatedFlowContainer animatedContainer = new AnimatedFlowContainer(Duration.millis(1500), ContainerAnimations.FADE);
		try {
			drawer.setContent(flowHandler.start(animatedContainer));
		} catch (FlowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		context.register("ContentPane", drawer.getContent().get(0));

		// side controller will add links to the content flow [all links will disappear if this deleted in the Fxdrawer]
		Flow sideMenuFlow = new Flow(SideMenuController.class);
		sideMenuFlowHandler = sideMenuFlow.createHandler(context);

        //set drawer content with animation
		try {
			drawer.setSidePane(sideMenuFlowHandler.start(new AnimatedFlowContainer(Duration.millis(5000), ContainerAnimations.SWIPE_LEFT)));
		} catch (FlowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



	

	/*Now we loaded 2 fxml in same frame of scene*/
}
