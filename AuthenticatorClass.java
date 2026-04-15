/* WAP to demonstrate the Authenticator class */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class AuthenticatorClass {
    public static void main(String[] args) {
        try {
            // Set default authenticator
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    System.out.println("Authentication requested for: " + getRequestingHost());
                    return new PasswordAuthentication("user", "passwd".toCharArray());
                }
            });

            // Try accessing a protected URL
            URL url = new URL("http://httpbin.org/basic-auth/user/passwd");
            URLConnection connection = url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
