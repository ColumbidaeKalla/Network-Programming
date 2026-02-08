/* WAP to print IP Address and MAC Address of a host */

import java.net.InetAddress;
import java.net.NetworkInterface;

public class IPandMACAddress {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            byte[] mac = NetworkInterface.getByInetAddress(host).getHardwareAddress();

            System.out.println("Host Name: " + host.getHostName());
            System.out.println("IP Address: " + host.getHostAddress());

            if (mac != null) {
                System.out.print("MAC Address: ");
                for (int i = 0; i < mac.length; i++) {
                    System.out.format("%02X%s",
                            mac[i], (i < mac.length - 1) ? "-" : "");
                }
                System.out.println();
            } else {
                System.out.println("MAC Address: Not Available");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
