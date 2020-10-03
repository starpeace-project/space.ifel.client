package client.servers.clients.models.galaxy;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Galaxy {
    @JsonProperty("quadrants")
    public List<Quadrant> getQuadrants() {
        return this.quadrants;
    }

    public void setQuadrants(List<Quadrant> quadrants) {
        this.quadrants = quadrants;
    }

    List<Quadrant> quadrants;

    public Quadrant findQuadrant(String quadrantName) throws Exception {
        for (int i = 0; i < quadrants.size(); i++) {
            if (quadrants.get(i).getName().equals(quadrantName.toLowerCase())) {
                return quadrants.get(i);
            }
        }

        throw new Exception("Unable to locate quadrant.");
    }
}
