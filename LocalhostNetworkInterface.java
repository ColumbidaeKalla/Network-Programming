/* WAP to print Network interface of localhost */

import java.net.InetAddress;
import java.net.NetworkInterface;

public class LocalhostNetworkInterface {
    public static void main(String[] args) {
        try {
            InetAddress inet = InetAddress.getLocalHost();
    
            NetworkInterface ni = NetworkInterface.getByInetAddress(inet);
    
            if (ni != null) {
                System.out.println("Localhost Ip Address: " + inet.getHostAddress());
                System.out.println("Interface Name: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());
                System.out.println("Loopback: " + ni.isLoopback());
            } else {
                System.out.println("No Network interface found for the localhost");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
