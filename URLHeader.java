/* WAP to print all HTTP response headers. */

import java.net.URL;
import java.net.URLConnection;

public class URLHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            URLConnection connection = url.openConnection();

            for (int i = 0;; i++) {
                String value = connection.getHeaderField(i);
                String key = connection.getHeaderFieldKey(i);

                if (value == null)
                    break;

                if (key == null)
                    System.out.println("Status Line: " + value);
                else
                    System.out.println(key + ": " + value);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
