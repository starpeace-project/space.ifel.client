package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;
import client.servers.clients.models.WorldServerDetails;

public class GetWorldServerDetails {
    public WorldServerDetails getWorldServerDetails(TcpClient interfaceServer) throws Exception {
        WorldServerDetails serverDetails = new WorldServerDetails();

        // C 22 sel 31287108 get WorldName;A22 WorldName="$Chipango";
        int worldCallNumber = interfaceServer.getCallCounter();
        String worldName = interfaceServer.send("C " + worldCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldName;");
        worldName = worldName.replace("A" + worldCallNumber + " WorldName=\"$", "");
        worldName = worldName.replace("\"", "");
        serverDetails.setWorldName(worldName);

        // C 23 sel 31287108 get WorldURL;A23 WorldURL="$http://willow.starpeaceonline.com/Five/";
        int worldUrlCallNumber = interfaceServer.getCallCounter();
        String worldUrl = interfaceServer.send("C " + worldUrlCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldURL;");
        worldUrl = worldUrl.replace("A" + worldCallNumber + " WorldUrl=\"$", "");
        worldUrl = worldUrl.replace("\"", "");
        serverDetails.setWorldUrl(worldUrl);

        // C 24 sel 31287108 get DAAddr;A24 DAAddr="$78.46.87.219";
        int daAddrCallNumber = interfaceServer.getCallCounter();
        String daAddr = interfaceServer.send("C " + daAddrCallNumber + " sel " + interfaceServer.getObjectId() + " get DAAddr;");
        daAddr = daAddr.replace("A" + daAddrCallNumber + " DAAddr=\"$", "");
        daAddr = daAddr.replace("\"", "");
        serverDetails.setDaAddress(daAddr);

        //  C 25 sel 31287108 get DALockPort;A25 DALockPort="#7001";
        int daLockPortCallNumber = interfaceServer.getCallCounter();
        String daLockPort = interfaceServer.send("C " + daLockPortCallNumber + " sel " + interfaceServer.getObjectId() + " get DALockPort;");
        daLockPort = daLockPort.replace("A" + daLockPortCallNumber + " DALockPort=\"#", "");
        daLockPort = daLockPort.replace("\"", "");
        serverDetails.setDaPort(Integer.parseInt(daLockPort));

        // C 26 sel 31287108 get MailAddr;A26 MailAddr="$78.46.87.219";
        int mailAddrCallNumber = interfaceServer.getCallCounter();
        String mailAddr = interfaceServer.send("C " + mailAddrCallNumber + " sel " + interfaceServer.getObjectId() + " get MailAddr;");
        mailAddr = mailAddr.replace("A" + mailAddrCallNumber + " MailAddr=\"$", "");
        mailAddr = mailAddr.replace("\"", "");
        serverDetails.setMailAddress(mailAddr);

        // C 27 sel 31287108 get MailPort;A27 MailPort="#10000";
        int mailPortCallNumber = interfaceServer.getCallCounter();
        String mailPort = interfaceServer.send("C " + mailPortCallNumber + " sel " + interfaceServer.getObjectId() + " get MailPort;");
        mailPort = mailPort.replace("A" + mailPortCallNumber + " MailPort=\"#", "");
        mailPort = mailPort.replace("\"", "");
        serverDetails.setMailPort(Integer.parseInt(mailPort));

        // C 28 sel 31287108 get WorldXSize;A28 WorldXSize="#1000";
        int worldXSizeCallNumber = interfaceServer.getCallCounter();
        String worldXSize = interfaceServer.send("C " + worldXSizeCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldXSize;");
        worldXSize = worldXSize.replace("A" + worldXSizeCallNumber + " WorldXSize=\"#", "");
        worldXSize = worldXSize.replace("\"", "");
        serverDetails.setWorldXSize(Integer.parseInt(worldXSize));

        // C 29 sel 31287108 get WorldYSize;A29 WorldYSize="#1000";
        int worldYSizeCallNumber = interfaceServer.getCallCounter();
        String worldYSize = interfaceServer.send("C " + worldYSizeCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldYSize;");
        worldYSize = worldYSize.replace("A" + worldYSizeCallNumber + " WorldYSize=\"#", "");
        worldYSize = worldYSize.replace("\"", "");
        serverDetails.setWorldYSize(Integer.parseInt(worldYSize));

        // C 30 sel 31287108 get WorldSeason;A30 WorldSeason="#3";
        int worldSeasonCallNumber = interfaceServer.getCallCounter();
        String worldSeason = interfaceServer.send("C " + worldSeasonCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldSeason;");
        worldSeason = worldSeason.replace("A" + worldYSizeCallNumber + " WorldSeason=\"#", "");
        worldSeason = worldSeason.replace("\"", "");
        serverDetails.setWorldYSize(Integer.parseInt(worldSeason));

        return serverDetails;
    }
}
