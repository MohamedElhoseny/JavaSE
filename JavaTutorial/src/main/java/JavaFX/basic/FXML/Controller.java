package JavaFX.basic.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML private Button btn;
    @FXML private Label lbl;

    @FXML
    public void handlesubmit(ActionEvent event)
    {
        btn.setText("Stop Clicking Me");
        lbl.setText("Submit Button Clicked !");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Loading Databases ..");
    }


}
