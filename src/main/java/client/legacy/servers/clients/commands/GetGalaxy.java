package client.legacy.servers.clients.commands;

import client.servers.clients.TcpClient;
import client.servers.clients.models.galaxy.Galaxy;
import client.servers.clients.models.galaxy.Quadrant;
import client.servers.clients.models.galaxy.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetGalaxy {
    public Galaxy getGalaxy(TcpClient dirClient) throws Exception {
        String america = dirClient.send(getRequestString(dirClient, "America"));
        String europe = dirClient.send(getRequestString(dirClient, "Europe"));
        String asia = dirClient.send(getRequestString(dirClient, "Asia"));

        Galaxy galaxy = new Galaxy();

        List<Quadrant> quadrants = new ArrayList<>();

        quadrants.add(getQuadrant(america, "America"));
        quadrants.add(getQuadrant(europe, "Europe"));
        quadrants.add(getQuadrant(asia, "Asia"));

        galaxy.setQuadrants(quadrants);

        return galaxy;
    }

    private String getRequestString(TcpClient dirClient, String area) {
        return "C " + dirClient.getCallCounter() + " sel " + dirClient.getSessionId() + " call RDOQueryKey \"^\" \"%Root/Areas/" + area + "/Worlds\",\"%General/Population\n" +
                "General/Investors\n" +
                "General/Online\n" +
                "General/Date\n" +
                "Interface/IP\n" +
                "Interface/Port\n" +
                "Interface/URL\n" +
                "Interface/Running\n" +
                "\";";
    }

    private Quadrant getQuadrant(String data, String quadrantName) {
        String regex = "Count=(\\d+?)";
        int resultCount = 0;
        List<World> worlds = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()) {
            resultCount = Integer.parseInt(matcher.group(1));
        }

        Quadrant quadrant = new Quadrant();
        quadrant.setName(quadrantName);

        if (resultCount == 0) {
            return quadrant;
        }

        for (int i = 0; i < resultCount; i++) {
            World thisWorld = new World();

            String keyRegex = "Key" + i + "=(.+?)\\r\\n";
            Pattern keyPattern = Pattern.compile(keyRegex, Pattern.DOTALL);
            Matcher keyMatcher = keyPattern.matcher(data);
            if (keyMatcher.find()) {
                thisWorld.setName((keyMatcher.group(1).substring(0, 1).toUpperCase() + keyMatcher.group(1).substring(1)));
            }

            thisWorld.setImage("world" + new Random().nextInt(10) + ".png");

            String dateRegex = "general/date" + i + "=(.+?)\\r\\n";
            Pattern datePattern = Pattern.compile(dateRegex, Pattern.DOTALL);
            Matcher dateMatcher = datePattern.matcher(data);
            if (dateMatcher.find()) {
                thisWorld.setDate(Integer.parseInt(dateMatcher.group(1)));
            }

            String investorRegex = "general/investors" + i + "=(.+?)\\r\\n";
            Pattern investorPattern = Pattern.compile(investorRegex, Pattern.DOTALL);
            Matcher investorMatcher = investorPattern.matcher(data);
            if (investorMatcher.find()) {
                thisWorld.setInvestors(Integer.parseInt(investorMatcher.group(1)));
            }

            String onlineRegex = "general/online" + i + "=(.+?)\\r\\n";
            Pattern onlinePattern = Pattern.compile(onlineRegex, Pattern.DOTALL);
            Matcher onlineMatcher = onlinePattern.matcher(data);
            if (onlineMatcher.find()) {
                thisWorld.setInvestors(Integer.parseInt(onlineMatcher.group(1)));
            }

            String populationRegex = "general/population" + i + "=(.+?)\\r\\n";
            Pattern populationPattern = Pattern.compile(populationRegex, Pattern.DOTALL);
            Matcher populationMatcher = populationPattern.matcher(data);
            if (populationMatcher.find()) {
                thisWorld.setPopulation(Integer.parseInt(populationMatcher.group(1)));
            }

            // Interface Details

            String ipRegex = "interface/ip" + i + "=(.+?)\\r\\n";
            Pattern ipPattern = Pattern.compile(ipRegex, Pattern.DOTALL);
            Matcher ipMatcher = ipPattern.matcher(data);
            if (ipMatcher.find()) {
                thisWorld.setInterfaceIp(ipMatcher.group(1));
            }

            String portRegex = "interface/port" + i + "=(.+?)\\r\\n";
            Pattern portPattern = Pattern.compile(portRegex, Pattern.DOTALL);
            Matcher portMatcher = portPattern.matcher(data);
            if (portMatcher.find()) {
                thisWorld.setInterfacePort(Integer.parseInt(portMatcher.group(1)));
            }

            String runningRegex = "interface/running" + i + "=(.+?)\\r\\n";
            Pattern runningPattern = Pattern.compile(runningRegex, Pattern.DOTALL);
            Matcher runningMatcher = runningPattern.matcher(data);
            if (runningMatcher.find()) {
                thisWorld.setRunning(Boolean.parseBoolean(runningMatcher.group(1)));
            }

            String urlRegex = "interface/url" + i + "=(.+?)\\r\\n";
            Pattern urlPattern = Pattern.compile(urlRegex, Pattern.DOTALL);
            Matcher urlMatcher = urlPattern.matcher(data);
            if (urlMatcher.find()) {
                thisWorld.setInterfaceUrl(urlMatcher.group(1));
            }

            worlds.add(thisWorld);
        }

        quadrant.setWorlds(worlds);

        return quadrant;
    }
}
