package client.servers.clients;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    private static TcpClient instance;
    private final InetAddress server;
    private final int port;
    private Socket socket;

    private int callCounter = 0;
    private int sessionId = 0;
    private int objectId = 0;

    public TcpClient(InetAddress server, int port) {
        this.server = server;
        this.port = port;
        instance = this;
    }

    public TcpClient connect() throws IOException {
        System.out.println("Connecting to Server");
        this.socket = new Socket(this.server, this.port);
        System.out.println("Socket Connected");
        System.out.println("Connected to server.");
        return this;
    }

    public String send(String message) throws Exception {
        if (!socket.isConnected()) {
            connect();
        }

        PrintWriter output = new PrintWriter(socket.getOutputStream(),
                true);
        BufferedReader input = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));

        System.out.println("Sending message: " + message);
        output.println(message);

        System.out.println("Returning response");

        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = input.read()) >= 0 && ch != ';') {
            sb.append((char)ch);
        }

        callCounter++;
        return sb.toString();
    }

    public int getCallCounter() {
        return this.callCounter;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public static TcpClient getInstance() {
        return instance;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
