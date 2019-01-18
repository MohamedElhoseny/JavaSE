package JavaFX.Jfoenix.Components;

import com.jfoenix.animation.JFXNodesAnimation;
import com.jfoenix.controls.JFXButton;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationDemo extends Application {

	@Override public void start(Stage stage)
    {
         //dh flow layout 3wzo bs 3shan a7ot feh 4 circles gnb b3d   OK!
		FlowPane main = new FlowPane();
		main.setVgap(20);
		main.setHgap(20);

        /******************************** StackPane  Circles **************************************/
		StackPane colorPane = new StackPane();
		colorPane.setStyle("-fx-background-radius:50; -fx-min-width:50; -fx-min-height:50;");
		colorPane.getStyleClass().add("red-500");

		StackPane colorPane1 = new StackPane();  //-fx-background-radius:50;   make the plane Circle
		colorPane1.setStyle("-fx-background-radius:50; -fx-min-width:50; -fx-min-height:50;");
		colorPane1.getStyleClass().add("blue-500");

        StackPane colorPane2 = new StackPane();
        colorPane2.setStyle("-fx-background-radius:50; -fx-min-width:50; -fx-min-height:50;");
        colorPane2.getStyleClass().add("green-500");

        StackPane colorPane3 = new StackPane();
        colorPane3.setStyle("-fx-background-radius:50; -fx-min-width:50; -fx-min-height:50;");
        colorPane3.getStyleClass().add("yellow-500");

        StackPane colorPane4 = new StackPane();
        colorPane4.setStyle("-fx-background-radius:50; -fx-min-width:50; -fx-min-height:50;");
        colorPane4.getStyleClass().add("purple-500");


           //adding circles to flow layout
        main.getChildren().add(colorPane);
		StackPane placeHolder = new StackPane(colorPane1);
		placeHolder.setStyle("-fx-background-radius:50; -fx-min-width:50; -fx-min-height:50;");
		main.getChildren().add(placeHolder);
        main.getChildren().add(colorPane2);
        main.getChildren().add(colorPane3);
        main.getChildren().add(colorPane4);

        /****************** Now Next i want to add the flow layout to StackPane (main layout) ********/

		StackPane wizard = new StackPane();
		wizard.getChildren().add(main);
		StackPane.setMargin(main, new Insets(100)); //100,100,100,100  Move in Frame


       /***********    How to Make the Animation  ?? *********/

               /* Preparing to Next Scene Preview */

        //Making Second Pane that will appear after the animation
		StackPane nextPage = new StackPane();
        //Creating Some Components and Adding them To Next Scene Pane
        Label mylabel = new Label("Hello In Next Page !!");
        mylabel.setStyle("-fx-text-fill: White");
        JFXButton mybutton = new JFXButton("Hello");
        mybutton.getStyleClass().add("button-raised");
        mybutton.setStyle("-fx-background-color: #00c853");
		nextPage.getChildren().addAll(mylabel,mybutton);
		StackPane.setAlignment(mylabel,Pos.TOP_CENTER);

        /* ********************************* Making The @@ Animation using [JFXNodesAnimation Class] *********************************/
		JFXNodesAnimation<FlowPane, StackPane> animation = new JFXNodesAnimation<FlowPane, StackPane>(main,nextPage)
        {
      // <~>  == <FlowPane,StackPane>
    //JFXNodesAnimation<FlowPane, StackPane> =>  m3naha el animation hy7sl mn FlowPane 3la StackPane : (main , nextPage)   main = flowPane  nextpage =stackPane

            private Pane tempPage = new Pane();
			double x = 0;
			double y = 0;

            @Override  // 1
			public void init()  //initialize method
            {
				nextPage.setOpacity(0);   //booooooooooos  hna hwa 3ml elPlane el gded el opacity m5fe w byzhr wa7da wa7da
				// hna bndef el temp w next page le main layout fe initialization
                wizard.getChildren().add(tempPage);
				wizard.getChildren().add(nextPage);


                //localToScene bybos 3la scene w bygeb el Bounds bta3t Node (x , y)
				x = colorPane1.localToScene(colorPane1.getBoundsInLocal()) .getMinX();
				y = colorPane1.localToScene(colorPane1.getBoundsInLocal()) .getMinY();

                //by7ot el circle el2wl fe temp pane 2le by7sl 3leh el animation w next pane hwa 2le hyzhr b2a
				tempPage.getChildren().add(colorPane1);

                //setTranslateX( x )  hna by7rk el x l8ayt lma ywslha le x=0 bound
                 colorPane1.setTranslateX(x);
				colorPane1.setTranslateY(y);

                System.out.println("Initialize Method Finished !");
			}
			@Override //5
			public void end() {
				System.out.println("Animation carried out !!");
			}
			
			@Override //3
			public Animation animateSharedNodes() {
                System.out.println("AnimateSharedNodes function called and returned new TimeLine Object !");
                return new Timeline();   //exception if not return TimeLine object
			}
			
			@Override //2
			public Animation animateExit() {
                System.out.println("animateExit() function doing !");
				return new Timeline(                      // main.opacityProperty()   => y3ne hy8yr fe 2eh
						new KeyFrame(Duration.millis(300),new KeyValue(main.opacityProperty(), 0, Interpolator.EASE_BOTH)),

						new KeyFrame(Duration.millis(520),new KeyValue(colorPane1.translateXProperty(), 0, Interpolator.EASE_BOTH),
                                new KeyValue(colorPane1.translateYProperty(), 0, Interpolator.EASE_BOTH)),
                        new KeyFrame(Duration.millis(200), new KeyValue(colorPane1.scaleXProperty(), 1, Interpolator.EASE_BOTH),
                                new KeyValue(colorPane1.scaleYProperty(), 1, Interpolator.EASE_BOTH)),
						new KeyFrame(Duration.millis(1000),new KeyValue(colorPane1.scaleXProperty(), 40, Interpolator.EASE_BOTH),
                                new KeyValue(colorPane1.scaleYProperty(), 40, Interpolator.EASE_BOTH)));
			          //EASE_BOTH  => will make an animation start slow, then accelerate and slow down again towards the end, all in a smooth manner.
			}
			
			@Override //4
			public Animation animateEntrance() {
                System.out.println("animateEntrance function called !");
				return new Timeline(new KeyFrame(Duration.millis(320),new KeyValue(nextPage.opacityProperty(), 1, Interpolator.EASE_BOTH)));
			}
			
		};
		

		colorPane1.setOnMouseClicked((click)->{
			animation.animate();  //start animate
		});


		
		final Scene scene = new Scene(wizard, 800, 200);  //7t el wizard stackpane
		scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-design.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-components.css").toExternalForm());
		stage.setTitle("JFX Button Demo");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) { launch(args); }
	
}
