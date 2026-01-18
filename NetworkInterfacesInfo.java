/* WAP to print all Network Interfaces available on a machine */

import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInterfacesInfo {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();

                System.out.println("Interface Name: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName() + "\n");
                /* System.out.println("Up: " + ni.isUp());
                System.out.println("Loopback: " + ni.isLoopback());
                System.out.println("Virtual: " + ni.isVirtual()); */
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
