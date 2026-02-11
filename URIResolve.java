/* WAP to Resolve Base URI with Relative Path */

import java.net.URI;

public class URIResolve {
    public static void main(String[] args) {
        try {
            URI baseURI = new URI("http://example.com");
            URI relativePath = new URI("colleges/SWASTIK#admission");

            URI resolveURI = baseURI.resolve(relativePath);

            System.out.println("Base URI: " + baseURI);
            System.out.println("Relative Path: " + relativePath);
            System.out.println("Resolve URI: " + resolveURI);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
