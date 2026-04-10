/* WAP to retrieve cookie information and store it in the system */

import java.io.FileWriter;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class CookieManageStore {
    public static void main(String[] args) {
        try {
            // Create CookieManager
            CookieManager manager = new CookieManager();
            CookieHandler.setDefault(manager);

            // Open Connection to a website
            URL url = new URL("https://www.google.com/");
            URLConnection connection = url.openConnection();
            connection.getInputStream();

            // Get cookie from CookieStore
            CookieStore store = manager.getCookieStore();
            List<HttpCookie> cookies = store.getCookies();

            // Store cookie in a file
            FileWriter writer = new FileWriter("cookie.txt");

            for (HttpCookie cookie : cookies) {
                String data = "Name: " + cookie.getName() +
                        ", Value: " + cookie.getValue() +
                        ", Domain: " + cookie.getDomain() +
                        ", Path: " + cookie.getPath();

                System.out.println(data);
                writer.write(data + "\n");
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
