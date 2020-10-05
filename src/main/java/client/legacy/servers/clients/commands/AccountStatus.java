package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class AccountStatus {
    public int getAccountStatus(TcpClient interfaceServer, String username, String password) throws Exception {
        // C 31 sel 31287108 call AccountStatus "^" "%dodgerid","%NAHMATE";A31 res="#2";
        int callNumber = interfaceServer.getCallCounter();
        String message  = "C " + callNumber + " sel " + interfaceServer.getObjectId() + " call AccountStatus \"^\" \"%" + username + "\",\"%" + password + "\";";
        String response = interfaceServer.send(message);
        response = response.replace("A" + callNumber + " res=\"#", "");
        response = response.replace("\"", "");

        return Integer.parseInt(response);
    }
}
