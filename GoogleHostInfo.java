/* WAP to print the hostname, hostaddress, port, and protocol of www.google.com */

import java.net.InetAddress;
import java.net.URL;

public class GoogleHostInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            InetAddress inet = InetAddress.getByName(url.getHost());

            System.out.println("Host Name: " + inet.getHostName());
            System.out.println("Host Address: " + inet.getHostAddress());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Port: " + url.getDefaultPort());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
