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

    @JsonProperty("running")
    public boolean getRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    boolean running;

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

    @JsonProperty("interface_ip")
    public String getInterfaceIp() {
        return this.interfaceIp;
    }

    public void setInterfaceIp(String iface) {
        this.interfaceIp = iface;
    }

    String interfaceIp;

    @JsonProperty("interface_port")
    public int getInterfacePort() {
        return this.interfacePort;
    }

    public void setInterfacePort(int interfacePort) {
        this.interfacePort = interfacePort;
    }

    int interfacePort;


    @JsonProperty("interface_url")
    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    String interfaceUrl;

    @JsonProperty("date")
    public int getDate() {
        return this.date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int date;
}
