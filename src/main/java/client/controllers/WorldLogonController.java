package client.controllers;

import client.GameClient;
import client.servers.clients.models.WorldServerDetails;
import client.servers.clients.models.galaxy.Quadrant;
import client.servers.clients.models.galaxy.World;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;

public class WorldLogonController {
    private static WorldLogonController instance;

    private Quadrant quadrant;
    private World world;
    private WorldServerDetails worldServerDetails;

    @FXML
    Pane worldData;
    @FXML
    Pane worldInfo;

    @FXML
    ImageView worldImage;
    @FXML
    Label worldName;

    public WorldLogonController() {
        instance = this;
        quadrant = GameClient.getInstance().getQuadrant();
        world = GameClient.getInstance().getWorld();
        worldServerDetails = GameClient.getInstance().getWorldServerDetails();

        setUp();
    }

    public static WorldLogonController getInstance() {
        return instance;
    }

    public void setUp()
    {
        javafx.scene.image.Image worldImg = new Image(String.valueOf(getClass().getResource("/worlds/" + world.getImage())));
        worldImage = new ImageView(worldImg);
        System.out.print(world);
        worldName.setText(world.getName());
    }
}
