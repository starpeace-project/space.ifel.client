package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class Logon {
    public void logon(TcpClient interfaceClient, String username, String password) throws Exception {
        // C 32 sel 31287108 call Logon "^" "%dodgerid","%NAHMATE";A32 res="#31600636";
        int callNumber = interfaceClient.getCallCounter();
        String message  = "C " + callNumber + " sel " + interfaceClient.getObjectId() + " call Logon \"^\" \"%" + username + "\",\"%" + password + "\";";
        String response = interfaceClient.send(message);
        response = response.replace("A" + callNumber + " res=\"#", "");
        response = response.replace("\"", "");

        interfaceClient.setSessionId(Integer.parseInt(response));
    }
}
