package client.servers.clients.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.InetAddress;

public class WorldServerDetails {
    @JsonProperty("world_name")
    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public String worldName;

    @JsonProperty("world_url")
    public String getWorldUrl() {
        return worldUrl;
    }

    public void setWorldUrl(String worldUrl) {
        this.worldUrl = worldUrl;
    }

    public String worldUrl;

    @JsonProperty("da_address")
    public String getDaAddress() {
        return daAddress;
    }

    public void setDaAddress(String daAddress) {
        this.daAddress = daAddress;
    }

    public String daAddress;

    @JsonProperty("da_port")
    public int getDaPort() {
        return daPort;
    }

    public void setDaPort(int daPort) {
        this.daPort = daPort;
    }

    public int daPort;

    @JsonProperty("mail_address")
    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String mailAddress;

    @JsonProperty("mail_port")
    public int getMailPort() {
        return mailPort;
    }

    public void setMailPort(int mailPort) {
        this.mailPort = mailPort;
    }

    public int mailPort;

    @JsonProperty("world_x_size")
    public int getWorldXSize() {
        return worldXSize;
    }

    public void setWorldXSize(int worldXSize) {
        this.worldXSize = worldXSize;
    }

    public int worldXSize;

    @JsonProperty("world_y_size")
    public int getWorldYSize() {
        return worldYSize;
    }

    public void setWorldYSize(int worldYSize) {
        this.worldYSize = worldYSize;
    }

    public int worldYSize;

    @JsonProperty("world_season")
    public int getWorldSeason() {
        return worldSeason;
    }

    public void setWorldSeason(int worldSeason) {
        this.worldSeason = worldSeason;
    }

    public int worldSeason;

    @JsonProperty("tycoon_details")
    public int getTycoonId() {
        return tycoonId;
    }

    public void setTycoonId(int tycoonId) {
        this.tycoonId = tycoonId;
    }

    public int tycoonId;

    @JsonProperty("mail_account")
    public String getMailAccount() {
        return mailAccount;
    }

    public void setMailAccount(String mailAccount) {
        this.mailAccount = mailAccount;
    }

    public String mailAccount;
}
