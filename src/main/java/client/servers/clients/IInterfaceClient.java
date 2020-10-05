package client.servers.clients;

import client.servers.clients.models.WorldServerDetails;

public interface IInterfaceClient {

    void endSession() throws Exception;

    void beginSession() throws Exception;

    void login(String username, String password) throws Exception;

    WorldServerDetails getWorldServerData(String username, String password) throws Exception;
}
