package client.servers.clients.models;

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
    @FXML
    private ImageView eclipsedImage;
    @FXML
    private Label statusLabel;

    public WorldComponent(World world) {
        this.setId("world-pane");
        this.worldNameLabel = new Label();
        this.populationLabel = new Label();
        this.investorLabel = new Label();
        this.onlineLabel = new Label();
        this.yearLabel = new Label();
        this.statusLabel = new Label();

        URL worldUrl = getClass().getResource("/worlds/" + world.getImage());
        URL eclipseUrl = getClass().getResource("/worlds/eclipsed.png");
        URL cssUrl = getClass().getResource("/fxml/css/style.css");

        setWorldName(world.getName());
        setWorldImage(worldUrl);
        setEclipsedImage(eclipseUrl);
        setPopulation(String.valueOf(world.getPopulation()));
        setInvestors(String.valueOf(world.getInvestors()));
        setOnline(String.valueOf(world.getOnline()));
        setYear(String.valueOf(world.getDate()));
        setStatus(world.getEclipsed());

        this.maxHeight(-1);
        this.maxWidth(-1);
        this.minHeight(-1);
        this.minWidth(-1);
        this.prefHeight(400);
        this.prefWidth(354);
        this.getStyleClass().add("bg-gray");
        this.getStylesheets().add(cssUrl.toString());

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

        if (world.getEclipsed()) {
            this.eclipsedImage.fitHeightProperty().set(150);
            this.eclipsedImage.fitWidthProperty().set(200);
            this.eclipsedImage.setLayoutX(101);
            this.eclipsedImage.setLayoutY(75);
            this.eclipsedImage.pickOnBoundsProperty().set(true);
            this.eclipsedImage.preserveRatioProperty().set(true);
            this.eclipsedImage.setEffect(dropShadow);
            this.worldImage.toBack();
            this.eclipsedImage.toFront();
        }

        this.worldNameLabel.setWrapText(true);
        this.worldNameLabel.setLayoutY(235);
        this.worldNameLabel.getStyleClass().add("world-title");
        
        Label populationLabelLabel = new Label();
        populationLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        populationLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        populationLabelLabel.setLayoutX(90);
        populationLabelLabel.setLayoutY(269);
        populationLabelLabel.setPrefHeight(23);
        populationLabelLabel.setPrefWidth(87);
        populationLabelLabel.setText("Population");
        populationLabelLabel.getStyleClass().add("world");
        
        this.populationLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.populationLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.populationLabel.setLayoutX(177);
        this.populationLabel.setLayoutY(269);
        this.populationLabel.setPrefHeight(23);
        this.populationLabel.setPrefWidth(95);
        this.populationLabel.getStyleClass().add("world");
        
        Label investorsLabelLabel = new Label();
        investorsLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        investorsLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        investorsLabelLabel.setLayoutX(100);
        investorsLabelLabel.setLayoutY(292);
        investorsLabelLabel.setPrefHeight(23);
        investorsLabelLabel.setPrefWidth(95);
        investorsLabelLabel.setText("Investors");
        investorsLabelLabel.getStyleClass().add("world");

        this.investorLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.investorLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.investorLabel.setLayoutX(177);
        this.investorLabel.setLayoutY(292);
        this.investorLabel.setPrefHeight(23);
        this.investorLabel.setPrefWidth(95);
        this.investorLabel.getStyleClass().add("world");

        Label onlineLabelLabel = new Label();
        onlineLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        onlineLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        onlineLabelLabel.setLayoutX(118);
        onlineLabelLabel.setLayoutY(315);
        onlineLabelLabel.setPrefHeight(23);
        onlineLabelLabel.setPrefWidth(52);
        onlineLabelLabel.setText("Online");
        onlineLabelLabel.getStyleClass().add("world");

        this.onlineLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.onlineLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.onlineLabel.setLayoutX(177);
        this.onlineLabel.setLayoutY(338);
        this.onlineLabel.setPrefHeight(23);
        this.onlineLabel.setPrefWidth(95);
        this.onlineLabel.getStyleClass().add("world");

        Label yearLabelLabel = new Label();
        yearLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        yearLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        yearLabelLabel.setLayoutX(128);
        yearLabelLabel.setLayoutY(338);
        yearLabelLabel.setPrefHeight(23);
        yearLabelLabel.setPrefWidth(52);
        yearLabelLabel.setText("Year");
        yearLabelLabel.getStyleClass().add("world");
        
        this.yearLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.yearLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.yearLabel.setLayoutX(177);
        this.yearLabel.setLayoutY(315);
        this.yearLabel.setPrefHeight(23);
        this.yearLabel.setPrefWidth(95);
        this.yearLabel.getStyleClass().add("world");
        
        Label statusLabelLabel = new Label();
        statusLabelLabel.alignmentProperty().set(Pos.TOP_LEFT);
        statusLabelLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        statusLabelLabel.setLayoutX(68);
        statusLabelLabel.setLayoutY(361);
        statusLabelLabel.setPrefHeight(23);
        statusLabelLabel.setPrefWidth(102);
        statusLabelLabel.setText("World Status");
        statusLabelLabel.getStyleClass().add("world");
        
        this.statusLabel.alignmentProperty().set(Pos.TOP_LEFT);
        this.statusLabel.contentDisplayProperty().set(ContentDisplay.CENTER);
        this.statusLabel.setLayoutX(177);
        this.statusLabel.setLayoutY(361);
        this.statusLabel.setPrefHeight(23);
        this.statusLabel.setPrefWidth(145);
        this.statusLabel.getStyleClass().add("world");

        this.getChildren().add(this.worldNameLabel);
        this.getChildren().add(this.worldImage);
        if (world.getEclipsed()) {
            this.getChildren().add(eclipsedImage);
        }
        this.getChildren().add(populationLabelLabel);
        this.getChildren().add(this.populationLabel);
        this.getChildren().add(investorsLabelLabel);
        this.getChildren().add(this.investorLabel);
        this.getChildren().add(onlineLabelLabel);
        this.getChildren().add(this.onlineLabel);
        this.getChildren().add(yearLabelLabel);
        this.getChildren().add(this.yearLabel);
        this.getChildren().add(statusLabelLabel);
        this.getChildren().add(this.statusLabel);
    }

    public Label getWorldName() {
        return worldNameLabel;
    }

    public void setWorldName(String worldName) {
        this.worldNameLabel.setText(worldName);
    }

    public void setWorldImage(URL worldImage) {
        Image worldImg = new Image(String.valueOf(worldImage));
        this.worldImage = new ImageView(worldImg);
    }

    public void setEclipsedImage(URL eclipsedImage) {
        Image eclipse = new Image(String.valueOf(eclipsedImage));
        this.eclipsedImage = new ImageView(eclipse);
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
        System.out.println(year);
        this.yearLabel.setText(year);
    }

    public void setStatus(boolean status) {
        String message = status ? "ECLIPSED" : "ACCESSIBLE";
        this.statusLabel.setText(message);

        if (status) {
            this.statusLabel.setStyle("-fx-text-fill: red!important;");
        } else {
            this.statusLabel.setStyle("-fx-text-fill: green!important;");
        }
    }
}
