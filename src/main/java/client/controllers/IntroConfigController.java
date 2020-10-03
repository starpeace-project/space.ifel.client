package client.controllers;

import client.GameClient;
import client.configuration.Config;
import client.configuration.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class IntroConfigController {
    private static IntroConfigController instance;
    private Config config;

    private MediaPlayer mediaPlayer;
    private final Media introMusic = new Media(GameClient.class.getResource("/sound/bensound-newdawn.mp3").toString());
    private final AudioClip beeper = new AudioClip(GameClient.class.getResource("/sound/key_beep.wav").toString());

    public IntroConfigController() {
        instance = this;
        this.config = (Config) ConfigManager.get("config");

        mediaPlayer = new MediaPlayer(introMusic);
        mediaPlayer.setVolume(config.getIntroMusicVolume());
        if (config.getIntroMusic()) {
            mediaPlayer.setAutoPlay(true);
        }
    }

    @FXML
    private Slider introMusicVolumeSlider;
    @FXML
    private Slider beeperVolumeSlider;
    @FXML
    private CheckBox introMusicCheckbox;
    @FXML
    private CheckBox beeperCheckbox;
    @FXML
    private Button closeButton;

    public void initialize() {
        instance = this;

        beeperVolumeSlider.setValue(config.getBeeperVolume());
        introMusicVolumeSlider.setValue(config.getIntroMusicVolume());

        introMusicVolumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            config.setIntroMusicVolume((Double) newValue);
            mediaPlayer.setVolume((Double) newValue);
        });

        beeperVolumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            config.setBeeperVolume((Double) newValue);
            beeper.setVolume((Double) newValue);
        });

        introMusicCheckbox.setSelected(config.getIntroMusic());

        introMusicCheckbox.setOnAction(event -> {
            toggleIntroMusic();
        });

        beeperCheckbox.setSelected(config.getKeyBeeps());

        beeperCheckbox.setOnAction(event -> {
            toggleIntroKeyBeeps();
        });

        closeButton.setOnMouseClicked(event -> {
            GameClient.getInstance().restoreState();
        });
    }

    public static IntroConfigController getInstance() {
        return instance;
    }

    @FXML
    private void toggleIntroMusic() {
        config.setIntroMusic(!config.getIntroMusic());
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        } else {
            mediaPlayer.play();
        }
    }

    @FXML
    private void toggleIntroKeyBeeps() {
        config.setKeyBeeps(!config.getKeyBeeps());
        if (beeper.getVolume() >= 0) {
            beeper.setVolume(0);
        } else {
            beeper.setVolume(config.getBeeperVolume());
        }
    }

    public void beep() {
        beeper.play();
    }
}
