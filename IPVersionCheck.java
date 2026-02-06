/* WAP to check the ip address is v4 or v6 */

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public class IPVersionCheck {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("255.234.180.23");

            System.out.println("IP Address: " + ip.getHostAddress());

            if (ip instanceof Inet4Address) {
                System.out.println("Address Type: IPv4");
            } else if (ip instanceof Inet6Address) {
                System.out.println("Address Type: IPv6");
            } else {
                System.out.println("Address Type: Unknown");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
