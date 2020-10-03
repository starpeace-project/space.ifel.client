package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.ProgressBar;

public class Splash extends Application {

    public static Boolean isSplashLoaded = false;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Splash.class.getResource("/fxml/splash.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
