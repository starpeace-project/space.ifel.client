package client.controllers;

import client.servers.clients.models.WorldServerDetails;
import client.servers.clients.models.galaxy.Quadrant;
import client.servers.clients.models.galaxy.World;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class WebViewController {
    private static WebViewController instance;

    private Quadrant quadrant;
    private World world;
    private WorldServerDetails serverDetails;

    @FXML
    WebView webView;

    public WebViewController() {
        instance = this;
    }

    public static WebViewController getInstance()
    {
        return instance;
    }

    // /FIVE/0/Visual/Voyager/NewLogon/pleasewait.asp?frame_Id=LogonView&frame_Visibility=hidden&LangId=0

    public void initialize() {

    }

    public void setGalaxyDetails(Quadrant quadrant, World world, WorldServerDetails worldServerDetails) {
        this.quadrant = quadrant;
        this.world = world;
        this.serverDetails = worldServerDetails;
    }

    public void logonComplete() {
        webView.getEngine().load(world.getInterfaceUrl() + "0/visual/voyager/toolbar/toolbar.asp?WorldName=Xalion&MailAccount=dodgerid@Xalion.net&Company=dodge.diss&Tycoon=dodgerid&Password=AppleDigi123&DAAddr=78.46.87.220&DAPort=7201&ISAddr=xalion.starpeaceonline.com&ISPort=8200&SecurityId=127210424&Visitor=0&ClientViewId=123964600&frame_Height=100&frame_Id=Toolbar&frame_Align=bottom&LangId=0");
    }
}
