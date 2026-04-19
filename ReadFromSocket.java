/* WAP to read from a socket */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadFromSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Message from server: " + message);
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
