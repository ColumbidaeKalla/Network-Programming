/* WAP to print the last modified date, content length, and content type of URL */

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();

            System.out.println("URL : " + url);
            System.out.println("Last Modified: " + new Date(connection.getLastModified()));
            System.out.println("Content Length: " + connection.getContentLength());
            System.out.println("Content Type: " + connection.getContentType());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
