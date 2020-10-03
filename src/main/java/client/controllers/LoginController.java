package client.controllers;

import client.GameClient;
import client.utilities.GameState;
import client.utilities.StringUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController {
    private static LoginController instance;

    @FXML
    TextField loginAliasTextField;
    @FXML
    Label loginAliasErrorLabel;
    @FXML
    PasswordField loginPasswordTextField;
    @FXML
    Label loginPasswordErrorLabel;
    @FXML
    Label loginGeneralErrorLabel;
    @FXML
    ImageView cog;

    private Locale locale = Locale.getDefault();
    private ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);

    public LoginController() {
        instance = this;
    }

    public static LoginController getInstance() {
        return instance;
    }

    public void initialise() {
        loginAliasTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            IntroConfigController.getInstance().beep();
            if (StringUtils.isValidString(loginAliasTextField.getText())) {
                loginAliasErrorLabel.setText("");
                return;
            }
            loginAliasErrorLabel.setText(messages.getString("invalid_alias"));
        });

        loginPasswordTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            IntroConfigController.getInstance().beep();
        }));

        cog.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Opening Intro Config");
            GameClient.getInstance().setState(GameState.INTRO_CONFIG);
        });
    }


    @FXML
    private void goRegister() throws IOException {
        GameClient.getInstance().setState(GameState.REGISTER);
    }

    private void emptyLoginErrorLabels() {
        loginAliasErrorLabel.setText("");
        loginPasswordErrorLabel.setText("");
        loginGeneralErrorLabel.setText("");
    }

    @FXML
    private void doLogin() {
        emptyLoginErrorLabels();
        System.out.println("Logging in.");
        if (loginAliasTextField.getText().equals("")) {
            loginAliasErrorLabel.setText(messages.getString("enter_player_alias"));
            return;
        }
        if (loginPasswordTextField.getText().equals("")) {
            loginPasswordErrorLabel.setText(messages.getString("enter_password"));
            return;
        }

        // We are good to attempt login.

        GameClient.getInstance().setState(GameState.GALAXY);
    }
}
