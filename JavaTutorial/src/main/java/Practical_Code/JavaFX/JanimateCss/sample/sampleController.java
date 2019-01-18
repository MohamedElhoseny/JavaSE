package Practical_Code.JavaFX.JanimateCss.sample;

import Practical_Code.JavaFX.JanimateCss.AnimatedClass.SlideInLeft;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Elhosany on 10/1/2016.
 */

public class sampleController
{
    @FXML
    private Label animatedlabel;

    @FXML
    private JFXButton btn;

    @FXML
    public void animate(ActionEvent e)
    {
        System.out.println("Starting Animating !!");
        new SlideInLeft(animatedlabel).play();
    }

}
