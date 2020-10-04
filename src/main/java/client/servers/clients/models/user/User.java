package client.servers.clients.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    @JsonProperty("alias")
    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    String alias;

    @JsonProperty("session_id")
    public String getSessionId() {
        return this.sessionId;
    }

    public void setSession_id(String sessionId) {
        this.sessionId = sessionId;
    }

    String sessionId;

    @JsonProperty("worlds")
    public List<World> getWorlds() {
        return this.worlds;
    }

    public void setWorlds(List<World> worlds) {
        this.worlds = worlds;
    }

    List<World> worlds;

    @JsonProperty("quick_hashes")
    public List<QuickHash> getQuickHashes() {
        return this.quickHashes;
    }

    public void setQuickHashes(List<QuickHash> quickHashes) {
        this.quickHashes = quickHashes;
    }

    public List<QuickHash> quickHashes;

    @JsonProperty("chosen_world")
    public String chosenWorld() {
        return this.chosenWorld();
    }

    public void setChosenWorld(String chosenWorld) {
        this.chosenWorld = chosenWorld;
    }

    public String chosenWorld;

    @JsonProperty("quick_logon")
    public boolean quickLogon() {
        return this.quickLogon;
    }

    public void setQuickLogon(boolean quickLogon) {
        this.quickLogon = quickLogon;
    }

    public boolean quickLogon;
}
