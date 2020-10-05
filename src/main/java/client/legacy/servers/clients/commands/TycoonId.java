package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class TycoonId {
    public int getTycoonId(TcpClient interfaceServer) throws Exception {
        // C 34 sel 31600636 get TycoonId;A34 TycoonId="#35";
        int callNumber = interfaceServer.getCallCounter();
        String response = interfaceServer.send("C " + callNumber + " sel " + interfaceServer.getSessionId() + " get TycoonId;");
        response = response.replace("A" + callNumber + " TycoonId=\"#", "");
        response = response.replace("\"", "");

        return Integer.parseInt(response);
    }
}
