import java.net.InetAddress;

public class TestReachability {
    public static void main(String[] args) {
        try {
            boolean reachable = InetAddress.getByName("www.google.com").isReachable(2000);
            System.out.println(reachable);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
