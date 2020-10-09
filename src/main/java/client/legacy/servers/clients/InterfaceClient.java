package client.legacy.servers.clients;

import client.GameClient;
import client.legacy.servers.clients.commands.*;
import client.servers.clients.IInterfaceClient;
import client.servers.clients.TcpClient;
import client.servers.clients.models.WorldServerDetails;
import client.utilities.GameState;

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
    }

    @Override
    public void login(String username, String password) throws Exception {
        new Logon().logon(this.interfaceClient, username, password);
    }

    @Override
    public WorldServerDetails getWorldServerData(String username, String password) throws Exception {
        WorldServerDetails serverDetails = new GetWorldServerDetails().getWorldServerDetails(this.interfaceClient);
        if (new AccountStatus().getAccountStatus(this.interfaceClient, username, password) == 0) {
            login(username, password);
        } else {
            throw new Exception("Unable to connect to the interface server");
        }
        serverDetails.setMailAccount(new MailAccount().getMailAccount(this.interfaceClient));
        serverDetails.setTycoonId(new TycoonId().getTycoonId(this.interfaceClient));

        if (!checkWorldData(serverDetails)) {
            return null;
        }

        return serverDetails;
    }

    @Override
    public void getCompanyList() throws Exception {
        new GetCompanyList().getCompanyList(this.interfaceClient);
    }

    public boolean checkWorldData(WorldServerDetails worldServerDetails) {
        if (worldServerDetails.getWorldName() == null) {
            return false;
        }
        if (worldServerDetails.getWorldUrl() == null) {
            return false;
        }
        if (worldServerDetails.getDaAddress() == null) {
            return false;
        }
        if (worldServerDetails.getDaPort() == 0) {
            return false;
        }
        if (worldServerDetails.getMailAddress() == null) {
            return false;
        }
        if (worldServerDetails.getMailPort() == 0) {
            return false;
        }
        if (worldServerDetails.getWorldXSize() == 0) {
            return false;
        }
        if (worldServerDetails.getWorldYSize() == 0) {
            return false;
        }
        if (worldServerDetails.getWorldSeason() == 0) {
            return false;
        }
        if (worldServerDetails.getMailAccount() == null) {
            return false;
        }
        if (worldServerDetails.getTycoonId() == 0) {
            return false;
        }

        return true;
    }
}
