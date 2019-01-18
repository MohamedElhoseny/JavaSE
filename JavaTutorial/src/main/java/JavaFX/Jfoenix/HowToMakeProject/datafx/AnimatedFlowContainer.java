package JavaFX.Jfoenix.HowToMakeProject.datafx;
import io.datafx.controller.context.ViewContext;
import io.datafx.controller.flow.FlowContainer;
import io.datafx.controller.flow.container.ContainerAnimations;

import java.util.List;
import java.util.function.Function;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
    /* dah mesal le class 2nta mmken t3mlo w tst8dmo [by3lmk 2zay tst5dm el FlowContainer ]*/
/**
 * A {@link FlowContainer} that supports animation for the view change.
 */
public class AnimatedFlowContainer extends io.datafx.controller.flow.container.AnimatedFlowContainer implements FlowContainer<StackPane> {

    private StackPane root;
    private Duration duration;
    private Function<io.datafx.controller.flow.container.AnimatedFlowContainer, List<KeyFrame>> animationProducer; //dh no3 mt8er gded zy el int 3mleno fe enum class
    private Timeline animation;
    private ImageView placeholder;  //dh el goz2 2le msh fahmo

    /**
     * Defaults constructor that creates a container with a fade animation that last 320 ms.
     */
    public AnimatedFlowContainer() {
        this(Duration.millis(320));
    }   //as its default animation is Fade

    /**
     *  Creates a container with a fade animation and the given duration
     *
     * @param duration the duration of the animation
     */
    public AnimatedFlowContainer(Duration duration) {
        this(duration, ContainerAnimations.FADE);    //hna byb3t le super bta3o el duration w animation
    }

    /**
     *  Creates a container with the given animation type and  duration
     *
     * @param duration the duration of the animation
     * @param animation the animation type
     */
    /* ContainerAnimations dh bst2bl feh ContainerAnimations.FadeIn   msln l2n dh enum class*/
    public AnimatedFlowContainer(Duration duration, ContainerAnimations animation) {
        this(duration, animation.getAnimationProducer());   //bygeb el no3 animation 2le ana b3to le function deh
    }

    /**
     *    Creates a container with the given animation type and duration
     * @param duration  the duration of the animation
     * @param animationProducer   the {@link KeyFrame} instances that define the animation
     */
    public AnimatedFlowContainer(Duration duration, Function<io.datafx.controller.flow.container.AnimatedFlowContainer, List<KeyFrame>> animationProducer) {
        this.root = new StackPane();
        this.duration = duration;
        this.animationProducer = animationProducer;   //hna t2rebn ana 2le b7dd el animation w msh bst5dm el fade w w
        placeholder = new ImageView();
        placeholder.setPreserveRatio(true);
        placeholder.setSmooth(true);
    }
    
    public void changeAnimation(ContainerAnimations animation){    //OK
    	this.animationProducer = animation.getAnimationProducer();
    }

    @Override
    public <U> void setViewContext(ViewContext<U> context) {
        updatePlaceholder(context.getRootNode());
        if (animation != null) {
            animation.stop();
        }
        animation = new Timeline();
        animation.getKeyFrames().addAll(animationProducer.apply(this));
        animation.getKeyFrames().add(new KeyFrame(duration, (e) -> clearPlaceholder()));
        animation.play();
    }
    private void updatePlaceholder(Node newView)
    {   // mn8erha msh htla2e ay 7aga fe containers
        if (root.getWidth() > 0 && root.getHeight() > 0) {
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);
            Image placeholderImage = root.snapshot(parameters, new WritableImage((int) root.getWidth(), (int) root.getHeight()));
            placeholder.setImage(placeholderImage);
            placeholder.setFitWidth(placeholderImage.getWidth());
            placeholder.setFitHeight(placeholderImage.getHeight());
        } else {
            placeholder.setImage(null);
        }
        placeholder.setVisible(true);
        placeholder.setOpacity(1.0);
        root.getChildren().setAll(placeholder, newView);
        placeholder.toFront();
    }

    /**
     * Returns the {@link ImageView} instance that is used as a placeholder for the old view in each navigation animation.
     * @return
     */
    public ImageView getPlaceholder() {
        return placeholder;
    }

    /**
     * Returns the duration for the animation
     * @return the duration for the animation
     */
    public Duration getDuration() {
        return duration;
    }

    @Override
    public StackPane getView() {
        return root;
    }
    
    private void clearPlaceholder() {
    	root.getChildren().remove(placeholder);
//        placeholder.setImage(null);
//        placeholder.setVisible(false);
//        placeholder.setFitHeight(1);
//        placeholder.setFitWidth(1);
    }


}
