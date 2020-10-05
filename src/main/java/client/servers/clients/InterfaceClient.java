package client.servers.clients;

import client.configuration.Config;
import client.servers.clients.models.WorldServerDetails;
import client.servers.clients.models.galaxy.World;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterfaceClient implements IInterfaceClient {
    private final TcpClient dirClient;

    public InterfaceClient(InetAddress serverAddress, int interfacePort) throws IOException {
        this.dirClient = new TcpClient(serverAddress, interfacePort).connect();
    }

    @Override
    public void beginSession() {

    }

    @Override
    public boolean login(String username, String password) throws Exception {
        return false;
    }

    @Override
    public WorldServerDetails getWorldServerData(String username, String password) {
        return null;
    }


    @Override
    public void endSession() {

    }
}
