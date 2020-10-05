package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;

public class MailAccount {
    public String getMailAccount(TcpClient interfaceClient) throws Exception {
        // C 33 sel 31600636 get MailAccount;A33 MailAccount="$dodgerid@Chipango.net";
        int callNumber = interfaceClient.getCallCounter();
        String message  = "C " + callNumber + " sel " + interfaceClient.getSessionId() + " get MailAccount;";
        String response = interfaceClient.send(message);
        response = response.replace("A" + callNumber + " MailAccount=\"$", "");
        response = response.replace("\"", "");

        return response;
    }
}
