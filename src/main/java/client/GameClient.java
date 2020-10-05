package client;

import client.configuration.ClientConfig;
import client.configuration.Config;
import client.configuration.ConfigFactory;
import client.configuration.ConfigManager;
import client.legacy.servers.clients.DirectoryClient;
import client.servers.clients.*;
import client.servers.clients.models.WorldServerDetails;
import client.servers.clients.models.galaxy.Galaxy;
import client.servers.clients.models.galaxy.Quadrant;
import client.servers.clients.models.galaxy.World;
import client.utilities.FileUtils;
import client.utilities.GameState;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
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
    private Config config = (Config) ConfigManager.get("config");
    private IDirectoryClient dirClient;
    private IInterfaceClient interfaceClient;

    private Boolean loggedIn = false;
    private String username;
    private String password;

    private GameState state;
    private GameState lastState;

    private Galaxy galaxy;
    private Quadrant selectedQuadrant;
    private World selectedWorld;
    private WorldServerDetails worldServerDetails;


    public static void main(String[] args) {
        System.setProperty("javafx.preloader", ClientPreloader.class.getCanonicalName());
        launch(args);
    }

    public GameClient() throws Exception {
        instance = this;
        System.out.println("Registering game client shutdown hook.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down writing configs to disk.");
            try {
                this.dirClient.endSession();
                this.interfaceClient.endSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void init() throws Exception {
        this.dirClient = DirectoryClientFactory.getClient(config);
        notifyPreloader(new Preloader.ProgressNotification(10.0));

        this.dirClient.beginSession();
        notifyPreloader(new Preloader.ProgressNotification(20.0));

        this.galaxy = this.dirClient.getGalaxy();
        notifyPreloader(new Preloader.ProgressNotification(60.0));

        loadSceneRoots();
        notifyPreloader(new Preloader.ProgressNotification(100.0));
    }

    @Override
    public void start(Stage primaryStage) {
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

    public IDirectoryClient getDirectory() {
        return dirClient;
    }

    public boolean logIn(String username, String password) throws Exception {
        if (dirClient.login(username, password)) {
            this.loggedIn = true;
            this.username = username;
            this.password = password;
            setState(GameState.GALAXY);
        }

        return this.loggedIn;
    }

    public void setSelectedWorld(Quadrant quadrant, World world) throws Exception {
        this.selectedQuadrant = quadrant;
        this.selectedWorld = world;

        if (this.interfaceClient != null) {
            this.interfaceClient.endSession();
        }

        this.interfaceClient = InterfaceClientFactory.getClient(config, world);
        this.interfaceClient.beginSession();
        this.worldServerDetails = this.interfaceClient.getWorldServerData(this.username, this.password);

        setState(GameState.WORLD_LOGON);
    }

    public Galaxy getGalaxy() {
        return this.galaxy;
    }
}
