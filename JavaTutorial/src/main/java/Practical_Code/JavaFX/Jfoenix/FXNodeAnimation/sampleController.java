package Practical_Code.JavaFX.Jfoenix.FXNodeAnimation;

import com.jfoenix.animation.JFXNodesAnimation;
import com.jfoenix.controls.JFXButton;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Created by Elhosany on 9/18/2016.
 */
public class sampleController
{
    @FXML private Pane parent;
    @FXML private VBox main;
    @FXML private HBox btnpane;
    @FXML private StackPane colorpane;

    @FXML
    public void onReg()
    {
        StackPane nextpage = new StackPane();

        /** nextpage properties */
        JFXButton ok = new JFXButton("Thanks..");
        Label msg = new Label("Your Registration is Confirmed !");
        StackPane.setMargin(msg,new Insets(100,50,100,80));
        StackPane.setMargin(ok,new Insets(200,50,100,80));
        ok.getStyleClass().add("button-raised");
        msg.setStyle("-fx-text-fill: white");
        ok.setOnAction(event -> System.exit(0));
        nextpage.setStyle("-fx-background-color: #00c853");
        nextpage.getChildren().addAll(msg,ok);

        /** JFXNodesAnimation  */
        JFXNodesAnimation<StackPane,Pane> animation = new JFXNodesAnimation<StackPane, Pane>(nextpage, parent) {  /* hna ana b7dd men 2le hy2sr 3la el tane*/
            private Pane temppage = new Pane();  //best  pane->layout->components                   /* Note : 2ne daymn 2wl 7aga el newframe or page*/
            double x , y;

            @Override //initialization of animation
            public void init() {
                nextpage.setOpacity(0);  //first disappear the nextpage
                parent.getChildren().add(temppage);   //add an Empty White Pane
                parent.getChildren().add(nextpage);   //add the Nextpage which is disappear
                temppage.getChildren().add(colorpane);//add the target (that will be animated) to the Empty Pane
                /* lw mdftsh el colorpane fe temppage msh hshof el 2nemation w hwa bytrsm hashof lma y5ls w yft7le*/

                /* dol 3shan fkt a7rk 7aga fe mkan m3yn w y3ml el animate*/
                x = colorpane.localToScene(colorpane.getBoundsInLocal()).getMinX();
                y = colorpane.localToScene(colorpane.getBoundsInLocal()).getMinY();
                //  colorpane.setTranslateX(x);        [ msh 3wz a7rkha ]
                //  colorpane.setTranslateY(y);
            }
            @Override
            public Animation animateExit() {
                return new Timeline(
                        new KeyFrame(Duration.millis(300),new KeyValue(main.opacityProperty(), 0, Interpolator.EASE_BOTH)),
                         /**Scale = Moving*/
                      //  new KeyFrame(Duration.millis(1000), new KeyValue(colorpane.scaleXProperty(),300, Interpolator.EASE_BOTH),
                      //          new KeyValue(colorpane.scaleYProperty(), 300, Interpolator.EASE_BOTH)),

                      //  new KeyFrame(Duration.millis(1200),new KeyValue(colorpane.scaleXProperty(), 500, Interpolator.EASE_BOTH),
                      //          new KeyValue(colorpane.scaleYProperty(),500, Interpolator.EASE_BOTH)));

                        new KeyFrame(Duration.millis(500),new KeyValue(colorpane.scaleYProperty(),150,Interpolator.EASE_BOTH)),
                        new KeyFrame(Duration.millis(1000),new KeyValue(colorpane.scaleYProperty(),300,Interpolator.EASE_BOTH)),
                        new KeyFrame(Duration.millis(1200),new KeyValue(colorpane.scaleYProperty(),450,Interpolator.EASE_BOTH)));
                /* leh ana shelt el codes deh l2ne now ana fahm 100%  ana fe application 3wz el animation yzed fe Y bs msh m7tag el X fe 7aga*/
            }

            @Override  //yb2a el function deh b2ol feha el content bta3 new page hyzhr b3 2d 2eh
            public Animation animateEntrance() {
                return new Timeline(new KeyFrame(Duration.millis(3000),new KeyValue(nextpage.opacityProperty(), 1,Interpolator.EASE_BOTH)));
                //hna bt2olo 2nta ht8yr fe Opacity bta3 nextpage w t5leha be 1 fe 5 second with animation(Interpolator.EASE_BOTH)
            }



            @Override
            public Animation animateSharedNodes() {
                return new Timeline();
            }
            @Override
            public void end() {

            }

        };
        animation.animate();
    }
}
