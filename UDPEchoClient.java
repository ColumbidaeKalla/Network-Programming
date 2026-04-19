import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UDPEchoClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.print("Enter message: ");
            String message = userInput.readLine();

            byte[] sendData = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Send packet
            DatagramPacket request = new DatagramPacket(
                    sendData,
                    sendData.length,
                    serverAddress,
                    5000);
            clientSocket.send(request);

            // Receive response
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(response);

            String received = new String(response.getData(), 0, response.getLength());
            System.out.println("Echo from server: " + received);

            clientSocket.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}