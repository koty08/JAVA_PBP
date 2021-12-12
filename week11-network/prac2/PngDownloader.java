import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PngDownloader {
    public static Path get(String str){
        Path path = null;
        try{
            URL url = new URL(str);
            URLConnection conn = url.openConnection();

            String dirpath = "./";
            String filename = "get.png";
            path = Paths.get(dirpath+filename);

            InputStream is = conn.getInputStream();
            OutputStream os = new FileOutputStream(new File(dirpath, filename));

            int read_bytes = -1;
            byte[] buffer = new byte[4096];

            while((read_bytes = is.read(buffer)) != -1){
                os.write(buffer,0,read_bytes);
            }

            os.close();
            is.close();

        } catch (MalformedURLException ex){
            System.err.println(ex);
        } catch (IOException ex){
            System.err.println(ex);
        }
        return path;
    }
}
