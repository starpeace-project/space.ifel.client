package client.servers.clients.models;

import client.GameClient;
import client.servers.clients.models.galaxy.World;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.net.URL;

public class WorldComponent extends AnchorPane {
    @FXML
    private Label worldNameLabel;
    @FXML
    private ImageView worldImage;
    @FXML
    private Label populationLabel;
    @FXML
    private Label investorLabel;
    @FXML
    private Label onlineLabel;
    @FXML
    private Label yearLabel;

    public WorldComponent(World world) {
        this.worldNameLabel = new Label();
        this.populationLabel = new Label();
        this.investorLabel = new Label();
        this.onlineLabel = new Label();

        URL worldUrl = getClass().getResource("/worlds/" + world.getImage());
        URL cssUrl = getClass().getResource("/fxml/css/style.css");

        setWorldName(world.getName());
        setWorldImage(worldUrl);
        setPopulation(String.valueOf(world.getPopulation()));
        setInvestors(String.valueOf(world.getInvestors()));
        setOnline(String.valueOf(world.getOnline()));

        this.maxHeight(-1);
        this.maxWidth(-1);
        this.minHeight(-1);
        this.minWidth(-1);
        this.prefHeight(400);
        this.prefWidth(354);
        this.getStyleClass().add("bg-gray");
        this.getStylesheets().add(cssUrl.toString());

        this.worldNameLabel.setWrapText(true);
        this.worldNameLabel.setTextAlignment(TextAlignment.CENTER);
       // this.worldNameLabel.setContentDisplay(ContentDisplay.CENTER);
        this.worldNameLabel.setLayoutX(12);
        this.worldNameLabel.setLayoutY(27);
        this.worldNameLabel.prefHeight(33);
        this.worldNameLabel.prefWidth(327);
        this.worldNameLabel.getStyleClass().add("world-title");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

        this.worldImage.fitHeightProperty().set(150);
        this.worldImage.fitWidthProperty().set(200);
        this.worldImage.setLayoutX(101);
        this.worldImage.setLayoutY(75);
        this.worldImage.pickOnBoundsProperty().set(true);
        this.worldImage.preserveRatioProperty().set(true);
        this.worldImage.setEffect(dropShadow);
        
        Label populationLabelLabel = new Label();
        populationLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        populationLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        populationLabelLabel.setLayoutX(90);
        populationLabelLabel.setLayoutY(249);
        populationLabelLabel.setPrefHeight(23);
        populationLabelLabel.setPrefWidth(87);
        populationLabelLabel.setText("Population");
        populationLabelLabel.getStyleClass().add("world");
        
        this.populationLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.populationLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.populationLabel.setLayoutX(177);
        this.populationLabel.setLayoutY(249);
        this.populationLabel.setPrefHeight(23);
        this.populationLabel.setPrefWidth(95);
        this.populationLabel.getStyleClass().add("world");
        
        Label investorsLabelLabel = new Label();
        investorsLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        investorsLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        investorsLabelLabel.setLayoutX(100);
        investorsLabelLabel.setLayoutY(272);
        investorsLabelLabel.setPrefHeight(23);
        investorsLabelLabel.setPrefWidth(95);
        investorsLabelLabel.setText("Investors");
        investorsLabelLabel.getStyleClass().add("world");

        this.investorLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.investorLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.investorLabel.setLayoutX(177);
        this.investorLabel.setLayoutY(272);
        this.investorLabel.setPrefHeight(23);
        this.investorLabel.setPrefWidth(95);
        this.investorLabel.getStyleClass().add("world");

        Label onlineLabelLabel = new Label();
        onlineLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        onlineLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        onlineLabelLabel.setLayoutX(118);
        onlineLabelLabel.setLayoutY(295);
        onlineLabelLabel.setPrefHeight(23);
        onlineLabelLabel.setPrefWidth(52);
        onlineLabelLabel.setText("Online");
        onlineLabelLabel.getStyleClass().add("world");

        this.onlineLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.onlineLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.onlineLabel.setLayoutX(177);
        this.onlineLabel.setLayoutY(295);
        this.onlineLabel.setPrefHeight(23);
        this.onlineLabel.setPrefWidth(95);
        this.onlineLabel.getStyleClass().add("world");

        this.getChildren().add(this.worldNameLabel);
        this.getChildren().add(this.worldImage);
        this.getChildren().add(populationLabelLabel);
        this.getChildren().add(this.populationLabel);
        this.getChildren().add(investorsLabelLabel);
        this.getChildren().add(this.investorLabel);
        this.getChildren().add(onlineLabelLabel);
        this.getChildren().add(this.onlineLabel);
    }

    public Label getWorldName() {
        return worldNameLabel;
    }

    public void setWorldName(String worldName) {
        this.worldNameLabel.setText(worldName);
    }

    public void setWorldImage(URL worldImage) {
        System.out.println(worldImage);
        Image worldImg = new Image(String.valueOf(worldImage));
        this.worldImage = new ImageView(worldImg);
    }

    public String getPopulation() {
        return populationLabel.getText();
    }

    public void setPopulation(String population) {
        this.populationLabel.setText(population);
    }

    public String getInvestors() {
        return investorLabel.getText();
    }

    public void setInvestors(String investors) {
        this.investorLabel.setText(investors);
    }

    public String getOnline() {
        return onlineLabel.getText();
    }

    public void setOnline(String online) {
        this.onlineLabel.setText(online);
    }

    public String getYear() {
        return yearLabel.getText();
    }

    public void setYear(String year) {
        this.yearLabel.setText(year);
    }
}
