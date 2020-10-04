package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdofDirectoryServer {
    public int getObjectId(TcpClient dirClient) throws Exception {
        int callNumber = dirClient.getCallCounter();
        String message = "C " + callNumber + " idof \"DirectoryServer\";";

        String response = dirClient.send(message);

        String regex = "objid=\"(\\d+?)\"";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        throw new Exception("Unable to obtain object id.");
    }
}
