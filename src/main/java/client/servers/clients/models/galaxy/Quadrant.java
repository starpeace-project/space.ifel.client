package client.servers.clients.models.galaxy;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Quadrant {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("worlds")
    public List<World> getWorlds() {
        return this.worlds;
    }

    public void setWorlds(List<World> worlds) {
        this.worlds = worlds;
    }

    List<World> worlds;

    public World findWorld(String currentWorldname) {
        for (int i = 0; i < worlds.size(); i++) {
            if (worlds.get(i).getName().equals(currentWorldname)) {
                return worlds.get(i);
            }
        }

        return null;
    }
}

