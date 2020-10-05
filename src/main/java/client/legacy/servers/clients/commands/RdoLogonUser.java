package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class RdoLogonUser {
    public boolean logonUser(TcpClient dirClient, int sessionId, String userName, String password) throws Exception {
        //C 3 sel 165267116 call RDOLogonUser "^" "%dodgerid","%NAHMATE";A3 res="#0";
        String message = "C " + dirClient.getCallCounter() + " sel " + sessionId + " call RDOLogonUser \"^\" \"%" + userName + "\",\"%" + password + "\";";

        String response = dirClient.send(message);

        return response.contains("res=\"#0\"");
    }
}
