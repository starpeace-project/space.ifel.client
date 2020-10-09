package client.controllers;

import client.GameClient;
import client.utilities.EmailValidator;
import client.utilities.GameState;
import client.utilities.StringUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegisterController {
    private static RegisterController instance;

    // Register
    @FXML
    Label registerAliasErrorLabel;
    @FXML
    TextField registerAliasTextField;
    @FXML
    Label registerEmailErrorLabel;
    @FXML
    TextField registerEmailTextField;
    @FXML
    Label registerGeneralErrorLabel;
    @FXML
    ImageView cog;

    private Locale locale = Locale.getDefault();
    private ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);

    public RegisterController() {
        instance = this;
    }

    public static RegisterController getInstance() {
        return instance;
    }

    @FXML
    private void validateAlias() {
        IntroConfigController.getInstance().beep();
        if (StringUtils.isValidString(registerAliasTextField.getText())) {
            registerAliasErrorLabel.setText("");
            return;
        }
        registerAliasErrorLabel.setText(messages.getString("invalid_alias"));
    }

    @FXML
    private void validateEmail() {
        IntroConfigController.getInstance().beep();
        if (registerEmailTextField.getText().contains("@") && !EmailValidator.validate(registerEmailTextField.getText())) {
            registerEmailErrorLabel.setText(messages.getString("email_error"));
            return;
        }
        registerEmailErrorLabel.setText("");
    }

    @FXML
    private void configClick() throws IOException {
        IntroConfigController.getInstance().beep();
        GameClient.getInstance().setState(GameState.INTRO_CONFIG);
    }

    private void emptyRegisterErrorLabels() {
        registerAliasErrorLabel.setText("");
        registerEmailErrorLabel.setText("");
        registerGeneralErrorLabel.setText("");
    }

    @FXML
    private void doRegister() throws IOException {
        emptyRegisterErrorLabels();
        System.out.println("Doing Register");
        // Check if alias exists.
        if (registerEmailTextField.getText().equals("")) {
            registerEmailErrorLabel.setText(messages.getString("email_error"));
            return;
        }
        if (!GameClient.getInstance().getDirectory().checkPlayerAlias(registerAliasTextField.getText())) {
            registerAliasErrorLabel.setText(messages.getString("alias_exists"));
            return;
        }

        // We are good create the account.
        GameClient.getInstance().setState(GameState.GALAXY);
    }


    @FXML
    private void goLogin() throws IOException {
        GameClient.getInstance().setState(GameState.LOGIN);
    }

    @FXML
    private void buttonClick() {
        IntroConfigController.getInstance().beep();
    }
}
