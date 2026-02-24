/* WAP to encode "This string has space" and then decode it to the original string */

import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeDecode {
    public static void main(String[] args) {
        try {
            String original = "This string has space";

            String encoded = URLEncoder.encode(original, "UTF-8");
            System.out.println(encoded);

            String decoded = URLDecoder.decode(encoded, "UTF-8");
            System.out.println(decoded);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
