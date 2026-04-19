import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class SecureClient {
    public static void main(String[] args) {
        try {
            // Load truststore
            KeyStore ts = KeyStore.getInstance("JKS");
            ts.load(new FileInputStream("clienttruststore.jks"), "client123".toCharArray());

            // Initialize TrustManager
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ts);

            // Initialize SSL context
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, tmf.getTrustManagers(), null);

            SSLSocketFactory factory = sc.getSocketFactory();

            SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 5000);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Secure Server!");

            // Read response from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("Server response: " + response);

            socket.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}