import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

public class DNSClient {
    public static Optional<String> query(String urlString) {
        Optional<String> str = Optional.empty();
        try{
            InetAddress[] addresses = InetAddress.getAllByName(urlString);
            str = Optional.of(addresses[0].toString().split("/")[1]);
        } catch (UnknownHostException ex){
            System.out.println(urlString+"\t: Name or service not known.");
        }
        return str;
    }
}
