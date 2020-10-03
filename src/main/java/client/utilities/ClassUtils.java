package client.utilities;

public class ClassUtils {
    public static boolean isClass(final String fqdn, final String className) {
        try  {
            Class.forName(fqdn + "." + className);
            return true;
        }  catch (ClassNotFoundException e) {
            return false;
        }
    }
}
