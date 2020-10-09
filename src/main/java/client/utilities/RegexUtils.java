package client.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public static int extractInteger(String string) {
        System.out.println("Extracting integer: " + string);
        String regex = "\"#(\\d+?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            System.out.println("Matched: " + matcher.group(1));
            return Integer.parseInt(matcher.group(1));
        }

        return 0;
    }

    public static Number extractObjectId(String string) {
        String regex = "\"(\\d+?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return null;
    }

    public static String extractString(String string) {
        String regex = "\"\\$(.+?)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
