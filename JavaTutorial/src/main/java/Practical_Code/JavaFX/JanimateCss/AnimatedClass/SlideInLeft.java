package Practical_Code.JavaFX.JanimateCss.AnimatedClass;

import Animation.Transition.CachedTimelineTransition;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Created by Elhosany on 10/1/2016.
 */
public class SlideInLeft extends CachedTimelineTransition
{

    public SlideInLeft(Node node)
    {
        super(node, new Timeline(new KeyFrame[]{
                new KeyFrame(Duration.millis(500),  new KeyValue(node.translateXProperty(), Integer.valueOf(0), Interpolator.EASE_BOTH)),
                new KeyFrame(Duration.millis(1000), new KeyValue(node.translateXProperty(), Integer.valueOf(400), Interpolator.EASE_BOTH)),
                new KeyFrame(Duration.millis(1500), new KeyValue(node.translateXProperty(), Integer.valueOf(700), Interpolator.EASE_BOTH)),
                new KeyFrame(Duration.millis(1700), new KeyValue(node.translateXProperty(), Integer.valueOf(900), Interpolator.EASE_BOTH))
        }));

        //dh 2le 5lane m3rfsh ash8lha  Duration.seconds  msh  Duration.Milli
        this.setCycleDuration(Duration.seconds(1.0D));
        this.setDelay(Duration.seconds(0.2D));
    }
}



//css
/**
 @keyframes slideInLeft
 {
 from {
 transform: translate3d(-100%, 0, 0);
 visibility: visible;
 }

 to {
 transform: translate3d(0, 0, 0);
 }
 }

 */