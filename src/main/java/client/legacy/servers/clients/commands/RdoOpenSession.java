package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RdoOpenSession {
    public int getSessionId(TcpClient dirClient, int directoryServerObjectId) throws Exception {
        int callNumber = dirClient.getCallCounter();
        String message = "C " + callNumber + " sel " + directoryServerObjectId + " get RDOOpenSession;";

        String response = dirClient.send(message);

        String regex = "RDOOpenSession=\"#(\\d+?)\"";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        throw new Exception("Unable to obtain session id.");
    }
}
