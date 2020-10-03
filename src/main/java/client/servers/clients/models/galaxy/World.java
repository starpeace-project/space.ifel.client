package client.servers.clients.models.galaxy;

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

    @JsonProperty("image")
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String image;

    @JsonProperty("eclipsed")
    public boolean getEclipsed() {
        return this.eclipsed;
    }

    public void setEclipsed(boolean eclipsed) {
        this.eclipsed = eclipsed;
    }

    boolean eclipsed;

    @JsonProperty("population")
    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    int population;

    @JsonProperty("investors")
    public int getInvestors() {
        return this.investors;
    }

    public void setInvestors(int investors) {
        this.investors = investors;
    }

    int investors;

    @JsonProperty("online")
    public int getOnline() {
        return this.online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    int online;

    @JsonProperty("interface")
    public String getInterface() {
        return this.iface;
    }

    public void setInterface(String iface) {
        this.iface = iface;
    }

    String iface;

    @JsonProperty("interface_port")
    public int getInterfacePort() {
        return this.interfacePort;
    }

    public void setInterfacePort(int interfacePort) {
        this.interfacePort = interfacePort;
    }

    int interfacePort;

    @JsonProperty("model")
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    String model;

    @JsonProperty("model_direct_access_port")
    public int getModelDirectAccessPort() {
        return this.modelDirectAccessPort;
    }

    public void setModelDirectAccessPort(int modelDirectAccessPort) {
        this.modelDirectAccessPort = modelDirectAccessPort;
    }

    int modelDirectAccessPort;
}
