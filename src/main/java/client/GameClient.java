package client;

import client.configuration.ClientConfig;
import client.configuration.ConfigManager;
import client.servers.clients.DirectoryClient;
import client.servers.clients.models.WorldComponent;
import client.servers.clients.models.galaxy.Galaxy;
import client.servers.clients.models.galaxy.Quadrant;
import client.servers.clients.models.galaxy.World;
import client.utilities.GameState;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameClient extends Preloader {
    private static GameClient instance;

    private Locale locale = Locale.getDefault();
    private ResourceBundle messages = ResourceBundle.getBundle("i18n.messages", locale);
    private Stage applicationStage;
    private Parent loginRoot;
    private Parent registerRoot;
    private Parent galaxyRoot;
    private Parent introConfigRoot;
    private Parent worldLogonRoot;
    private Parent createCompanyRoot;

    private ConfigManager configManager = new ConfigManager("src/main/resources/config");
    private DirectoryClient dirClient = new DirectoryClient();

    private Boolean loggedIn = false;

    private GameState state;
    private GameState lastState;


    public static void main(String[] args) {
        System.setProperty("javafx.preloader", ClientPreloader.class.getCanonicalName());
        launch(args);
    }

    public GameClient() throws Exception {
        instance = this;
    }

    @Override
    public void init() throws Exception {


        loadSceneRoots();

        for (int i = 0; i < 50000; i++) {
            double progress = (100 * i) / 50000;
            notifyPreloader(new Preloader.ProgressNotification(progress));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationStage = primaryStage;
        applicationStage.setTitle(messages.getString("application_title"));
        applicationStage.setWidth(1024);
        applicationStage.setHeight(768);
        applicationStage.setFullScreen(true);

        applicationStage.getIcons().add(new Image(String.valueOf(GameClient.class.getResource("/logos/starpeace-logo.png"))));
        applicationStage.setScene(new Scene(loginRoot));

        setState(GameState.LOGIN);
    }

    public void setState(GameState newState) {
        this.lastState = state;
        this.state = newState;

        if (!loggedIn && state != GameState.INTRO_CONFIG && state != GameState.REGISTER) {
            state = GameState.LOGIN;
        }

        System.out.println("Switching on state: " + state);
        switch (state) {
            case LOGIN:
                renderLogin();
                break;
            case REGISTER:
                renderRegister();
                break;
            case GALAXY:
                renderGalaxy();
                break;
            case MAP:
                renderMap();
            case INTRO_CONFIG:
                renderIntroConfig();
                break;
            case WORLD_LOGON:
                renderWorldLogon();
                break;
            case CREATE_COMPANY:
                renderCreateCompany();
                break;
            default:
                loggedIn = false;
        }
    }

    private void renderCreateCompany() {
        applicationStage.getScene().setRoot(createCompanyRoot);
        applicationStage.show();
    }

    private void renderWorldLogon() {
        applicationStage.getScene().setRoot(worldLogonRoot);
        applicationStage.show();
    }

    public void restoreState() {
        setState(lastState);
    }

    public void renderLogin() {
        applicationStage.getScene().setRoot(loginRoot);
        applicationStage.show();
    }

    public void renderRegister() {
        applicationStage.getScene().setRoot(registerRoot);
        applicationStage.show();
    }

    public void renderGalaxy() {
        applicationStage.getScene().setRoot(galaxyRoot);
        applicationStage.show();
    }

    public void renderMap() {

    }

    public void renderIntroConfig() {
        applicationStage.getScene().setRoot(introConfigRoot);
        applicationStage.show();
    }

    private ClientConfig getConfig() throws Exception {
        return ConfigManager.get("config");
    }

    private void loadSceneRoots() throws IOException {
        loginRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/login.fxml"));
        registerRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/register.fxml"));
        introConfigRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/intro_config.fxml"));
        galaxyRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/galaxy.fxml"));
        worldLogonRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/world_logon.fxml"));
        createCompanyRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/create_company.fxml"));
    }

    public void refreshLoginRoot() throws IOException {
        loginRoot = FXMLLoader.load(GameClient.class.getResource("/fxml/login.fxml"));
    }

    public static GameClient getInstance() {
        return instance;
    }

    public DirectoryClient getDirectory() {
        return dirClient;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
