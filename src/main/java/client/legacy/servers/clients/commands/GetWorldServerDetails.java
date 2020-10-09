package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;
import client.servers.clients.models.WorldServerDetails;
import client.utilities.RegexUtils;

public class GetWorldServerDetails {
    public WorldServerDetails getWorldServerDetails(TcpClient interfaceServer) throws Exception {
        WorldServerDetails serverDetails = new WorldServerDetails();

        // C 22 sel 31287108 get WorldName;A22 WorldName="$Chipango";
        int worldCallNumber = interfaceServer.getCallCounter();
        String worldName = interfaceServer.send("C " + worldCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldName;");
        serverDetails.setWorldName(RegexUtils.extractString(worldName));

        // C 23 sel 31287108 get WorldURL;A23 WorldURL="$http://willow.starpeaceonline.com/Five/";
        int worldUrlCallNumber = interfaceServer.getCallCounter();
        String worldUrl = interfaceServer.send("C " + worldUrlCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldURL;");
        serverDetails.setWorldUrl(RegexUtils.extractString(worldUrl));

        // C 24 sel 31287108 get DAAddr;A24 DAAddr="$78.46.87.219";
        int daAddrCallNumber = interfaceServer.getCallCounter();
        String daAddr = interfaceServer.send("C " + daAddrCallNumber + " sel " + interfaceServer.getObjectId() + " get DAAddr;");
        serverDetails.setDaAddress(RegexUtils.extractString(daAddr));

        //  C 25 sel 31287108 get DALockPort;A25 DALockPort="#7001";
        int daLockPortCallNumber = interfaceServer.getCallCounter();
        String daLockPort = interfaceServer.send("C " + daLockPortCallNumber + " sel " + interfaceServer.getObjectId() + " get DALockPort;");
        serverDetails.setDaPort(RegexUtils.extractInteger(daLockPort));

        // C 26 sel 31287108 get MailAddr;A26 MailAddr="$78.46.87.219";
        int mailAddrCallNumber = interfaceServer.getCallCounter();
        String mailAddr = interfaceServer.send("C " + mailAddrCallNumber + " sel " + interfaceServer.getObjectId() + " get MailAddr;");
        serverDetails.setMailAddress(RegexUtils.extractString(mailAddr));

        // C 27 sel 31287108 get MailPort;A27 MailPort="#10000";
        int mailPortCallNumber = interfaceServer.getCallCounter();
        String mailPort = interfaceServer.send("C " + mailPortCallNumber + " sel " + interfaceServer.getObjectId() + " get MailPort;");
        serverDetails.setMailPort(RegexUtils.extractInteger(mailPort));

        // C 28 sel 31287108 get WorldXSize;A28 WorldXSize="#1000";
        int worldXSizeCallNumber = interfaceServer.getCallCounter();
        String worldXSize = interfaceServer.send("C " + worldXSizeCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldXSize;");
        serverDetails.setWorldXSize(RegexUtils.extractInteger(worldXSize));

        // C 29 sel 31287108 get WorldYSize;A29 WorldYSize="#1000";
        int worldYSizeCallNumber = interfaceServer.getCallCounter();
        String worldYSize = interfaceServer.send("C " + worldYSizeCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldYSize;");
        serverDetails.setWorldYSize(RegexUtils.extractInteger(worldYSize));

        // C 30 sel 31287108 get WorldSeason;A30 WorldSeason="#3";
        int worldSeasonCallNumber = interfaceServer.getCallCounter();
        String worldSeason = interfaceServer.send("C " + worldSeasonCallNumber + " sel " + interfaceServer.getObjectId() + " get WorldSeason;");
        serverDetails.setWorldYSize(RegexUtils.extractInteger(worldSeason));

        return serverDetails;
    }
}
