package client.servers.clients;

import client.servers.clients.models.galaxy.World;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterfaceClient {
    private final InetAddress ifaceAddress;
    private final int ifacePort;

    public InterfaceClient(World world) throws UnknownHostException {
        this.ifaceAddress = InetAddress.getByName(world.getInterface());
        this.ifacePort = world.getInterfacePort();
    }
}
