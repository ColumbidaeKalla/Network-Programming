/* WAP to join a computer system in a multicast group */

import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            // Multicast group address (must be in 224.0.0.0 – 239.255.255.255)
            InetAddress group = InetAddress.getByName("230.0.0.1");

            // Create multicast socket on port 5000
            MulticastSocket socket = new MulticastSocket(5000);

            // Join multicast group
            socket.joinGroup(group);
            System.out.println("Joined multicast group: " + group);

            // Leave group
            socket.leaveGroup(group);
            socket.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}