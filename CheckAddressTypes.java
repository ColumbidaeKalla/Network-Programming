/* WAP to check the address type of 255.234.180.23 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckAddressTypes {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("255.234.180.23");
            System.out.println("IP Address: " + address.getHostAddress());

            if (address.isAnyLocalAddress()) {
                System.out.println("Wildcard Address");
            } else if (address.isLoopbackAddress()) {
                System.out.println("Loopback Address");
            } else if (address.isMulticastAddress()) {
                System.out.println("Multicast Address");
            } else if (address.isLinkLocalAddress()) {
                System.out.println("Link Local Address");
            } else if (address.isSiteLocalAddress()) {
                System.out.println("Site Local Address");
            } else {
                System.out.println("Public / Unicast Address");
            }
        } catch (UnknownHostException e) {
            System.out.println("Error:  " + e.getMessage());
        }
    }
}
