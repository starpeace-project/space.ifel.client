package client.controllers;

import client.GameClient;
import client.configuration.Config;
import client.configuration.ConfigManager;
import client.configuration.QuickLogon;
import client.utilities.GameState;
import client.utilities.StringUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController {
    private static LoginController instance;

    private Config config;

    @FXML
    TextField loginAliasTextField;
    @FXML
    ComboBox<String> loginAliasComboBox;
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
    @FXML
    Pane pane;

    private Locale locale = Locale.getDefault();
    private ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);

    public LoginController() {
        instance = this;
        this.config = (Config) ConfigManager.get("config");
    }

    public static LoginController getInstance() {
        return instance;
    }

    public void initialize() {
        for (QuickLogon logon : config.getQuickLogons()) {
            loginAliasComboBox.getItems().add(logon.getAlias() + " - " + logon.getWorld());
        }
        if (config.getQuickLogon()) {
            loginAliasTextField.setVisible(false);
        } else {
            loginAliasComboBox.setVisible(false);
        }
    }

    @FXML
    private void validateAlias() {
        IntroConfigController.getInstance().beep();

        if (!config.getQuickLogon()) {
            if (StringUtils.isValidString(loginAliasTextField.getText())) {
                loginAliasErrorLabel.setText("");
                return;
            }
        } else {
            if (StringUtils.isValidString(loginAliasComboBox.getEditor().getText())) {
                loginAliasErrorLabel.setText("");
                return;
            }
        }

        loginAliasErrorLabel.setText(messages.getString("invalid_alias"));
    }

    @FXML
    private void validatePassword() {
        IntroConfigController.getInstance().beep();
    }

    @FXML
    private void configClick() throws IOException {
        IntroConfigController.getInstance().beep();
        GameClient.getInstance().setState(GameState.INTRO_CONFIG);
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
    private void doLogin() throws Exception {
        emptyLoginErrorLabels();

        String value = "";
        if (config.getQuickLogon()) {
            value = loginAliasComboBox.getValue();
        } else {
            value = loginAliasTextField.getText();
        }

        System.out.println("Logging in.");

        if (value == null || value.equals("")) {
            loginAliasErrorLabel.setText(messages.getString("enter_player_alias"));
            return;
        }

        if (loginPasswordTextField.getText().equals("")) {
            loginPasswordErrorLabel.setText(messages.getString("enter_password"));
            return;
        }

        // We are good to attempt login.

        //Fake login for now
        if (!GameClient.getInstance().logIn(value, loginPasswordTextField.getText())) {
            loginGeneralErrorLabel.setText(messages.getString("invalid_login"));
        }
    }

    @FXML
    public void buttonClick() {
        IntroConfigController.getInstance().beep();
    }
}
