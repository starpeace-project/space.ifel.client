package client.servers.clients;

import client.servers.clients.models.galaxy.Galaxy;

public interface IDirectoryClient {

    void beginSession() throws Exception;

    void endSession() throws Exception;

    Galaxy getGalaxy() throws Exception;

    boolean checkPlayerAlias(String text);

    boolean login(String username, String password) throws Exception;
}
