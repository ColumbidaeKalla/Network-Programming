/* WAP to demonstrate ProxySelector class */

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

public class ProxySelectorClass {
    public static void main(String[] args) {
        try {
            //Create a URI
            URI uri = new URI("https://www.google.com");

            //Get default ProxySelector
            ProxySelector selector = ProxySelector.getDefault();

            //Get list of proxies for the given URI
            List<Proxy> proxies = selector.select(uri);

            //Display proxy details
            for (Proxy proxy : proxies) {
                System.out.println("Proxy Type: " + proxy.type());

                SocketAddress address = proxy.address();
                if (address != null) {
                    System.out.println("Proxy Address: " + address.toString());
                } else {
                    System.out.println("No Proxy (Direct Connection)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
