package client.servers.clients.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuickHash {
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
