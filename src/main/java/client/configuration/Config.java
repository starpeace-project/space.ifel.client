package client.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Config implements ClientConfig {
    @JsonProperty("intro_music")
    public void setIntroMusic(boolean introMusic) {
        this.introMusic = introMusic;
    }

    public boolean getIntroMusic() {
        return introMusic;
    }

    public boolean introMusic;

    @JsonProperty("beeper")
    public void setKeyBeeps(boolean beeper) {
        this.beeper = beeper;
    }

    public boolean getKeyBeeps() {
        return beeper;
    }

    public boolean beeper;

    @JsonProperty("quick_logon")
    public boolean getQuickLogon() {
        return quickLogon;
    }

    public void setQuickLogon(boolean quickLogon) {
        this.quickLogon = quickLogon;
    }

    public boolean quickLogon;

    @JsonProperty("beeper_volume")
    public double getBeeperVolume() {
        return this.beeperVolume;
    }

    public void setBeeperVolume(double volume) {
        this.beeperVolume = volume;
    }

    public double beeperVolume;


    @JsonProperty("intro_music_volume")
    public double getIntroMusicVolume() {
        return this.introMusicVolume;
    }

    public void setIntroMusicVolume(double volume) {
        this.introMusicVolume = volume;
    }

    public double introMusicVolume;
}
