package client.legacy.servers.clients;

import client.legacy.servers.clients.commands.*;
import client.servers.clients.IDirectoryClient;
import client.servers.clients.TcpClient;
import client.servers.clients.models.galaxy.Galaxy;

import java.io.IOException;
import java.net.InetAddress;

public class DirectoryClient implements IDirectoryClient {
    private int sessionId;

    private final TcpClient dirClient;

    public DirectoryClient(InetAddress serverAddress) throws IOException {
        this.dirClient = new TcpClient(serverAddress, 1111).connect();
    }

    public void beginSession() throws Exception {
        int directoryObjectId = new IdofDirectoryServer().getObjectId(dirClient);
        System.out.println("Directory Server Object Id: " + directoryObjectId);
        sessionId = new RdoOpenSession().getSessionId(dirClient, directoryObjectId);
        System.out.println("Directory Server Session Id: " + sessionId);
    }

    @Override
    public void endSession() throws Exception {
        new RdoEndSession().endSession(dirClient, sessionId);
    }

    @Override
    public Galaxy getGalaxy() throws Exception {
        return new GetGalaxy().getGalaxy(dirClient, sessionId);
    }

    @Override
    public boolean checkPlayerAlias(String text) {
        return false;
    }

    @Override
    public boolean login(String username, String password) throws Exception {
        return new RdoLogonUser().logonUser(dirClient, sessionId, username, password);
    }
}
