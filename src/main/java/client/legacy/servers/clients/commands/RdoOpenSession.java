package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;
import client.utilities.RegexUtils;

public class RdoOpenSession {
    public int getSessionId(TcpClient dirClient) throws Exception {
        int callNumber = dirClient.getCallCounter();
        String message = "C " + callNumber + " sel " + dirClient.getObjectId() + " get RDOOpenSession;";

        int sessionId = RegexUtils.extractInteger(dirClient.send(message));

        System.out.println("Session Id got from server: " + sessionId);
        return sessionId;
    }
}
