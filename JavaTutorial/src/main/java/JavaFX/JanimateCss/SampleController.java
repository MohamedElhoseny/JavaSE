package JavaFX.JanimateCss;

import Animation.Transition.*;
import io.datafx.controller.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Elhosany on 9/25/2016.
 */

@FXMLController(value = "SampleResources/Sample.fxml", title = "JAnimateCss Demo")
public class SampleController {
	@FXML
	StackPane animatedPane;

	@FXML
	GridPane gridPane;

	// fading entraces
	@FXML
	public void btn1() {
		new FadeInTransition(animatedPane).play();
	}

	@FXML
	public void btn2() {
		new FadeInUpTransition(animatedPane).play();
	}

	@FXML
	public void btn3() {
		new FadeInDownTransition(animatedPane).play();
	}

	@FXML
	public void btn4() {
		new FadeInLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn5() {
		new FadeInRightTransition(animatedPane).play();
	}

	@FXML
	public void btn6() {
		new FadeInUpBigTransition(animatedPane).play();
	}

	@FXML
	public void btn7() {
		new FadeInDownBigTransition(animatedPane).play();
	}

	@FXML
	public void btn8() {
		new FadeInLeftBigTransition(animatedPane).play();
	}

	@FXML
	public void btn9() {
		new FadeInRightBigTransition(animatedPane).play();
	}

	// fading exits
	@FXML
	public void btn10() {
		new FadeOutTransition(animatedPane).play();
	}

	@FXML
	public void btn11() {
		new FadeOutUpTransition(animatedPane).play();
	}

	@FXML
	public void btn12() {
		new FadeOutDownTransition(animatedPane).play();
	}

	@FXML
	public void btn13() {
		new FadeOutLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn14() {
		new FadeOutRightTransition(animatedPane).play();
	}

	@FXML
	public void btn15() {
		new FadeOutUpBigTransition(animatedPane).play();
	}

	@FXML
	public void btn16() {
		new FadeOutDownBigTransition(animatedPane).play();
	}

	@FXML
	public void btn17() {
		new FadeOutLeftBigTransition(animatedPane).play();
	}

	@FXML
	public void btn18() {
		new FadeOutRightBigTransition(animatedPane).play();
	}

	// Attention
	@FXML
	public void btn19() {
		new FlashTransition(animatedPane).play();
	}

	@FXML
	public void btn20() {
		new PulseTransition(animatedPane).play();
	}

	@FXML
	public void btn21() {
		new ShakeTransition(animatedPane).play();
	}

	@FXML
	public void btn22() {
		new TadaTransition(animatedPane).play();
	}

	@FXML
	public void btn23() {
		new SwingTransition(animatedPane).play();
	}

	@FXML
	public void btn24() {
		new WobbleTransition(animatedPane).play();
	}

	@FXML
	public void btn25() {
		new HingeTransition(animatedPane).play();
	}

	// Flippers
	@FXML
	public void btn26() {
		new FlipTransition(animatedPane).play();
	}

	@FXML
	public void btn27() {
		new FlipInXTransition(animatedPane).play();
	}

	@FXML
	public void btn28() {
		new FlipOutYTransition(animatedPane).play();
	}

	@FXML
	public void btn29() {
		new FlipInYTransition(animatedPane).play();
	}

	@FXML
	public void btn30() {
		new FlipOutXTransition(animatedPane).play();
	}

	@FXML
	public void btn31() {
		new RollInTransition(animatedPane).play();
	}

	@FXML
	public void btn32() {
		new RollOutTransition(animatedPane).play();
	}

	// Bounces
	@FXML
	public void btn33() {
		new BounceTransition(animatedPane).play();
	}

	@FXML
	public void btn34() {
		new BounceInTransition(animatedPane).play();
	}

	@FXML
	public void btn35() {
		new BounceInUpTransition(animatedPane).play();
	}

	@FXML
	public void btn36() {
		new BounceInDownTransition(animatedPane).play();
	}

	@FXML
	public void btn37() {
		new BounceInLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn38() {
		new BounceInRightTransition(animatedPane).play();
	}

	@FXML
	public void btn39() {
		new BounceOutTransition(animatedPane).play();
	}

	@FXML
	public void btn40() {
		new BounceOutUpTransition(animatedPane).play();
	}

	@FXML
	public void btn41() {
		new BounceOutDownTransition(animatedPane).play();
	}

	@FXML
	public void btn42() {
		new BounceOutLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn43() {
		new BounceOutRightTransition(animatedPane).play();
	}

	// Rotations
	@FXML
	public void btn44() {
		new RotateInTransition(animatedPane).play();
	}

	@FXML
	public void btn45() {
		new RotateOutTransition(animatedPane).play();
	}

	@FXML
	public void btn46() {
		new RotateInDownLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn47() {
		new RotateOutDownLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn48() {
		new RotateInDownRightTransition(animatedPane).play();
	}

	@FXML
	public void btn49() {
		new RotateOutDownRightTransition(animatedPane).play();
	}

	@FXML
	public void btn50() {
		new RotateInUpLeftTransition(animatedPane).play();
	}

	@FXML
	public void btn51() {
		new RotateInUpRightTransition(animatedPane).play();
	}

	@FXML
	public void btn52() {
		new RotateOutUpRightTransition(animatedPane).play();
	}

}
