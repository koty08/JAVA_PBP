import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadHttpServer {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/api/hello", exchange -> {
                OutputStream output = exchange.getResponseBody();
                if ("GET".equals(exchange.getRequestMethod())){
                    sleep(1000);
                    String responseBody = "Hello, World!\n";
                    exchange.getResponseHeaders().add("Content-Type", "text/html");
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseBody.getBytes().length);
                    output.write(responseBody.getBytes());
                    output.flush();
                    System.out.println(Thread.currentThread().getName() + " - Done!");
                } else {
                    exchange.sendResponseHeaders(405, "NOT_ALLOWED".length());
                    output.write("NOT_ALLOWED".getBytes());
                    output.flush();
                }
                exchange.close();
            });
            server.setExecutor(executor); //default ServiceExecutor
            server.start();
//            executor.shutdown();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }
}