package client.servers.clients.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class World {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("last_x")
    public int getLast_x() {
        return this.last_x;
    }

    public void setLast_x(int last_x) {
        this.last_x = last_x;
    }

    int last_x;

    @JsonProperty("last_y")
    public int getLast_y() {
        return this.last_y;
    }

    public void setLast_y(int last_y) {
        this.last_y = last_y;
    }

    int last_y;
}
