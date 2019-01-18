package JavaFX.basic.Intermediate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SimpleFormCss extends Application
{
    boolean accept;
    @Override
    public void start(Stage window) throws Exception
    {
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setHgap(8);
        layout.setVgap(10);
        //setConstraints(Node e, int coloumn ,int row)

        //errors labels
        Label n_error = new Label("Wrong Username !"), p_error = new Label("Wrong Password !"),e_error = new Label("Wrong email!"),a_error=new Label("Wrong Age !");
            n_error.setId("n_error");  //for style
            n_error.setVisible(false);
            p_error.setVisible(false);
            e_error.setVisible(false);
            a_error.setVisible(false);

        //name
        Label name = new Label("UserName : ");
        GridPane.setConstraints(name,0,0);
        //name input
        TextField name_input = new TextField();
        name_input.setPromptText("Your username");
        GridPane.setConstraints(name_input,1,0);
        //handle name error
        GridPane.setConstraints(n_error,2,0);
        //password
        Label pass = new Label("Password : ");
        GridPane.setConstraints(pass,0,1);
        //password input
        PasswordField pass_input = new PasswordField();
        pass_input.setPromptText("Your password");
        GridPane.setConstraints(pass_input,1,1);
        //handle pass error
        GridPane.setConstraints(p_error,2,1);
        //email
        Label email = new Label("Email  :");
        GridPane.setConstraints(email,0,2);
        //email_input
        TextField em = new TextField();
        em.setPromptText("Your Email");
        GridPane.setConstraints(em,1,2);
        //handle email error
        GridPane.setConstraints(e_error,2,2);
        //age
        Label age = new Label("Age  :");
        GridPane.setConstraints(age,0,3);
        //age_input
        TextField a = new TextField();
        a.setPromptText("Your Age");
        GridPane.setConstraints(a,1,3);
        //handle age error
        GridPane.setConstraints(a_error,2,3);
        //Confirm
        Button ok = new Button("Register");
        GridPane.setConstraints(ok,1,4);
        ok.setOnAction(event -> {

            accept = true;
            n_error.setVisible(false);
            p_error.setVisible(false);
            e_error.setVisible(false);
            a_error.setVisible(false);
            validate_user(name_input,n_error);
            validate_email(em,e_error);
            validate_pass(pass_input,p_error);
            validate_age(a,a_error);
            if (accept)
                System.out.println("Registerated !");
        });

        layout.getChildren().addAll(name,name_input,n_error,pass,pass_input,p_error,email,em,e_error,age,a_error,a,ok);
        Scene scene = new Scene(layout,400,250);
        scene.getStylesheets().add(getClass().getResource("form.css").toExternalForm());
        window.setScene(scene);
        window.setTitle("Registeration Form");
        window.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private void validate_user(TextField in,Label error_msg)
    {
        String username = in.getText();
        if (username.isEmpty() || username.contains("@") || username.contains(".")) {
            error_msg.setVisible(true);
            accept = false;
        }
    }
    private void validate_pass(PasswordField in,Label error_msg)
    {
        String pass = in.getText();
        if (pass.contains("@") || pass.length() < 6 || pass.isEmpty())
        {
            error_msg.setVisible(true);
            accept=false;
        }
    }
    private void validate_email(TextField in,Label error_msg){
        String e = in.getText();
        if (e.contains("@") && e.contains(".com")) {
            error_msg.setVisible(false);
            accept = true;
        }else {
            error_msg.setVisible(true);
            accept = false;
        }
    }
    private void validate_age(TextField in,Label error_msg){
        try {
           int x = Integer.parseInt(in.getText());
        }catch (NumberFormatException e) {
            error_msg.setVisible(true);
            accept=false;
        }
    }

}
