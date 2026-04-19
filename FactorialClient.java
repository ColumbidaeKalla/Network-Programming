/* Program that takes input from client */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter a number: ");
            int num = Integer.parseInt(userInput.readLine());

            out.println(num);

            String response = in.readLine();
            System.out.println("Server Response: " + response);

            socket.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}