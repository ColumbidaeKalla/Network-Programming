/* WAP to create a secure client socket to read from a secure server socket. */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SecureServer {
    public static void main(String[] args) {
        try {
            int port = 5000;

            // Load keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream("serverkeystore.jks"), "sunil123".toCharArray());

            // Initialize KeyManager
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, "sunil123".toCharArray());

            // Initialize SSL context
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(kmf.getKeyManagers(), null, null);

            SSLServerSocketFactory ssf = sc.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(port);

            System.out.println("Secure Server started on port " + port);

            SSLSocket socket = (SSLSocket) serverSocket.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();
            System.out.println("Received: " + message);

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}