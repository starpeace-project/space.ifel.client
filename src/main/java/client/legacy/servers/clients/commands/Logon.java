package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;
import client.utilities.RegexUtils;

public class Logon {
    public void logon(TcpClient interfaceClient, String username, String password) throws Exception {
        // C 32 sel 31287108 call Logon "^" "%dodgerid","%NAHMATE";A32 res="#31600636";
        String message  = "C " + interfaceClient.getCallCounter() + " sel " + interfaceClient.getObjectId() + " call Logon \"^\" \"%" + username + "\",\"%" + password + "\";";
        String response = interfaceClient.send(message);
        interfaceClient.setSessionId(RegexUtils.extractInteger(response));
    }
}
