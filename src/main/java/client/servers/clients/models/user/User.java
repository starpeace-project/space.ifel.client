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
}
