package client.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuickLogon {
    @JsonProperty("alias")
    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    String alias;

    @JsonProperty("world")
    public String getWorld() {
        return this.world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    String world;

    @JsonProperty("hash")
    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String hash;
}
