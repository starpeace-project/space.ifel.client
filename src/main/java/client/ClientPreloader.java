package client;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ClientPreloader extends Preloader {
    private Stage preloaderStage;
    private Scene scene;

    @FXML
    ProgressBar progressBar;

    public ClientPreloader() {
    }

    @Override
    public void init() {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(Splash.class.getResource("/fxml/splash.fxml"));
                loader.setController(this);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                scene.setFill(Color.TRANSPARENT);

                this.scene = scene;
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) {
        this.preloaderStage = primaryStage;
        // Set preloader scene and show stage.
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        preloaderStage.setScene(scene);
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        // Handle application notification in this point (see MyApplication#init).
        if (info instanceof ProgressNotification) {
            progressBar.setProgress(((ProgressNotification) info).getProgress()/100);
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                // Called after MyPreloader#start is called.
//                System.out.println("BEFORE_LOAD");
                break;
            case BEFORE_INIT:
                // Called before MyApplication#init is called.
//                System.out.println("BEFORE_INIT");
                break;
            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
//                System.out.println("BEFORE_START");

                preloaderStage.hide();
                break;
        }
    }
}
