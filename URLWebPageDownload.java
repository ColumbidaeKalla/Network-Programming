/* WAP to Download a Web Page*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLWebPageDownload {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(2000);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            FileWriter writer = new FileWriter("download_page.html");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }

            reader.close();
            writer.close();

            System.out.println("Web page downloaded successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
