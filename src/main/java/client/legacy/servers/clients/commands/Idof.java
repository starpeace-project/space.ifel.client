package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Idof {
    public int getObjectId(TcpClient tcpClient, String serverType) throws Exception {
        int callNumber = tcpClient.getCallCounter();
        String message = "C " + callNumber + " idof \"" + serverType + "\";";

        String response = tcpClient.send(message);

        String regex = "objid=\"(\\d+?)\"";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        throw new Exception("Unable to obtain object id.");
    }
}
