package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class RdoEndSession {
    public void endSession(TcpClient dirClient) throws Exception {
        int callNumber = dirClient.getCallCounter();
        String message = "C " + callNumber + " sel " + dirClient.getSessionId() + " call RDOEndSession \"*\" ;";
        System.out.println(dirClient.send(message));
        System.out.println("Session with directory server ended.");
    }
}
