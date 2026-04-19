/* Day-Time Client that Connects to server */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String response = in.readLine();
            System.out.println(response);

            socket.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}