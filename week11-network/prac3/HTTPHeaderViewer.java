import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HTTPHeaderViewer {
    public static Map<String, String> getHeaders(String urlString) {
        String content_type = "";
        try{
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("HEAD");
            content_type = conn.getHeaderField("Content-Type");
        } catch (MalformedURLException ex){
            System.err.println(ex);
        } catch (IOException ex){
            System.err.println(ex);
        }
        return Map.of("Content-Type", content_type);
    }
}
