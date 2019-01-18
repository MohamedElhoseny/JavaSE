package JavaFX.Jfoenix.HowToMakeProject.gui.uicomponents;

import io.datafx.controller.FXMLController;

@FXMLController(value = "/resources/fxml/ui/Button.fxml" , title = "Material Design Example")

public class ButtonController
{

  public void onclick(){
      System.out.println("clicked");
  }

}
