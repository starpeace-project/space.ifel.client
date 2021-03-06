package client.controllers;

import client.GameClient;
import client.servers.clients.models.WorldComponent;
import client.servers.clients.models.galaxy.Galaxy;
import client.servers.clients.models.galaxy.Quadrant;
import client.servers.clients.models.galaxy.World;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class GalaxyController {
    private static GalaxyController instance;

    private Galaxy galaxy;

    @FXML
    TabPane galaxyTabPane;

    public GalaxyController() {
        instance = this;
        galaxy = GameClient.getInstance().getGalaxy();
    }

    public void initialize () {
        for (Quadrant quadrant : galaxy.getQuadrants()) {
            Tab newTab = new Tab();
            newTab.setText(quadrant.getName()); // Area name
            FlowPane flowPane = new FlowPane();
            for (World world : quadrant.getWorlds()) {
                WorldComponent worldComponent = new WorldComponent(world);
                worldComponent.setOnMouseClicked(event -> {
                    try {
                        worldSelected(quadrant, world);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                flowPane.getChildren().add(worldComponent);
            }
            newTab.setContent(flowPane);
            galaxyTabPane.getTabs().add(newTab);
        }
    }
    public static GalaxyController getInstance() {
        return instance;
    }

    public void worldSelected(Quadrant quadrant, World world) throws Exception {
        GameClient.getInstance().setSelectedWorld(quadrant, world);
    }
}
