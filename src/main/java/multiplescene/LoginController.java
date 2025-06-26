package multiplescene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import multiplescene.util.MultipleString;

import java.io.IOException;


public class LoginController {

    private Main main;

    @FXML
    private TextField userText;

    //@FXML
    //private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    protected void loginAction(ActionEvent event) {
        String userName = userText.getText();
        //String password = passwordText.getText();
//        LoginDTO loginDTO = new LoginDTO();
//        loginDTO.setUserName(userName);
//        loginDTO.setPassword(password);
        MultipleString str=new MultipleString("login",userName);
        try {
            //main.getSocketWrapper().write(loginDTO);
            main.getSocketWrapper().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        //passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }

}
