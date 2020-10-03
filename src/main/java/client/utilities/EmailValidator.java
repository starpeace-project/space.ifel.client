package client.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java email validation program
 */
public class EmailValidator {
    // Email Regex java
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    /**
     * This method validates the input email address with EMAIL_REGEX pattern
     *
     * @param email String
     * @return boolean
     */
    public static boolean validate(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}