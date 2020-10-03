package client.servers.clients.models.galaxy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GalaxyRoot {
    @JsonProperty("galaxy")
    public Galaxy getGalaxy() {
        return this.galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    Galaxy galaxy;
}
