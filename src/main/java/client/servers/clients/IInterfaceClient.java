package client.servers.clients;

import client.servers.clients.models.WorldServerDetails;

public interface IInterfaceClient {
    void beginSession() throws Exception;

    void login(String username, String password) throws Exception;

    WorldServerDetails getWorldServerData(String username, String password) throws Exception;

    void getCompanyList() throws Exception;
}
