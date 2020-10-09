package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class GetCompanyList {
    // ? C 12 sel 23423234 call GetCompanyList "^" "%dodgerid";
    public void getCompanyList(TcpClient interfaceServer) throws Exception {
        String message = "C " + interfaceServer.getCallCounter() + " sel " + interfaceServer.getSessionId() + " call GetCompanyList \"^\" \"%dodgerid\";";
        System.out.println("Message: " + message);
        String response = interfaceServer.send(message);
        System.out.println("Response: " + response);
        System.exit(0);
    }
}
