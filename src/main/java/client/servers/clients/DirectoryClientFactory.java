package client.servers.clients;

import client.configuration.Config;

import java.io.IOException;
import java.net.InetAddress;

public class DirectoryClientFactory {
    public static IDirectoryClient getClient(Config config) throws IOException {
        InetAddress serverAddress = InetAddress.getByName(config.getDirectoryServer());

        if (config.getLegacyMode()) {
            return new client.legacy.servers.clients.DirectoryClient(serverAddress);
        }

        return new client.servers.clients.DirectoryClient(serverAddress);
    }
}
