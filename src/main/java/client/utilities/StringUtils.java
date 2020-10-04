package client.utilities;

public class StringUtils {
    public static String toCamelCase(final String init, final String separator) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(separator)) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

    public static boolean isValidString(String s) {
        boolean valid = true;

        char[] a = s.toCharArray();

        for (char c : a) {
            valid = ((c >= 'a') && (c <= 'z')) ||
                    ((c >= 'A') && (c <= 'Z')) ||
                    ((c >= '0') && (c <= '9')) ||
                    c == '_' || c == ' ';

            if (!valid) {
                break;
            }
        }

        return valid;
    }
}
