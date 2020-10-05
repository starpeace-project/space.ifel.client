package client.servers.clients;

import client.configuration.Config;
import client.servers.clients.models.galaxy.World;

import java.io.IOException;
import java.net.InetAddress;

public class InterfaceClientFactory {
    public static IInterfaceClient getClient(Config config, World world) throws IOException {
        InetAddress serverAddress = InetAddress.getByName(world.getInterfaceIp());

        if (config.getLegacyMode()) {
            return new client.legacy.servers.clients.InterfaceClient(serverAddress, world.getInterfacePort());
        }

        return new client.servers.clients.InterfaceClient(serverAddress, world.getInterfacePort());
    }
}
