package client.legacy.servers.clients;

import client.legacy.servers.clients.commands.*;
import client.servers.clients.IInterfaceClient;
import client.servers.clients.TcpClient;
import client.servers.clients.models.WorldServerDetails;

import java.io.IOException;
import java.net.InetAddress;

public class InterfaceClient implements IInterfaceClient {
    private final TcpClient interfaceClient;

    public InterfaceClient(InetAddress serverAddress, int interfacePort) throws IOException {
        this.interfaceClient = new TcpClient(serverAddress, interfacePort).connect();
    }

    @Override
    public void beginSession() throws Exception {
        this.interfaceClient.setObjectId(new Idof().getObjectId(interfaceClient, "InterfaceServer"));
        System.out.println("Interface Server Object Id: " + interfaceClient.getObjectId());
        this.interfaceClient.setSessionId(new RdoOpenSession().getSessionId(interfaceClient));
        System.out.println("Interface Server Session Id: " + interfaceClient.getSessionId());
    }

    @Override
    public void login(String username, String password) throws Exception {
        new Logon().logon(this.interfaceClient, username, password);
    }

    @Override
    public WorldServerDetails getWorldServerData(String username, String password) throws Exception {
        WorldServerDetails serverDetails = new GetWorldServerDetails().getWorldServerDetails(this.interfaceClient);
        if (new AccountStatus().getAccountStatus(this.interfaceClient, username, password) == 2) {
            login(username, password);
        }
        serverDetails.setMailAccount(new MailAccount().getMailAccount(this.interfaceClient));
        serverDetails.setTycoonId(new TycoonId().getTycoonId(this.interfaceClient));

        return serverDetails;
    }

    @Override
    public void endSession() throws Exception {
        new RdoEndSession().endSession(interfaceClient);
    }
}
