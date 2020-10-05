package client.legacy.servers.clients;

import client.legacy.servers.clients.commands.*;
import client.servers.clients.IDirectoryClient;
import client.servers.clients.TcpClient;
import client.servers.clients.models.galaxy.Galaxy;

import java.io.IOException;
import java.net.InetAddress;

public class DirectoryClient implements IDirectoryClient {
    private final TcpClient dirClient;

    public DirectoryClient(InetAddress serverAddress) throws IOException {
        this.dirClient = new TcpClient(serverAddress, 1111).connect();
    }

    public void beginSession() throws Exception {
        this.dirClient.setObjectId(new Idof().getObjectId(dirClient, "DirectoryServer"));
        System.out.println("Directory Server Object Id: " + dirClient.getObjectId());
        this.dirClient.setSessionId(new RdoOpenSession().getSessionId(dirClient));
        System.out.println("Directory Server Session Id: " + dirClient.getSessionId());
    }

    @Override
    public void endSession() throws Exception {
        new RdoEndSession().endSession(dirClient);
    }

    @Override
    public Galaxy getGalaxy() throws Exception {
        return new GetGalaxy().getGalaxy(dirClient);
    }

    @Override
    public boolean checkPlayerAlias(String text) {
        return false;
    }

    @Override
    public boolean login(String username, String password) throws Exception {
        return new RdoLogonUser().logonUser(dirClient, username, password);
    }
}
