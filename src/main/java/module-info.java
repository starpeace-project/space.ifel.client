module client {
    requires javafx.graphics;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.logging;
    requires javafx.controls;
    requires java.sql;
    requires jackson.databind;
    requires java.desktop;
    requires jackson.annotations;
    requires javafx.media;

    opens client;
    opens client.controllers to javafx.fxml;

    exports client;
    exports client.utilities;
    exports client.controllers;
    exports client.configuration;
    exports client.servers.clients.models.user;
    exports client.servers.clients.models.galaxy;
    exports client.servers.clients.models.factories;
}