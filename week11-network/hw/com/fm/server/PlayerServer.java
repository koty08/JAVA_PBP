package com.fm.server;

import com.fm.server.model.PlayerRepository;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerServer {
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 9000;
    private static final int BACKLOG = 1;

    static {
        PlayerRepository.getInstance().load();
    }

    public static void main(final String... args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG);
        server.createContext("/players", new PlayerHandler());
//        server.createContext("/quit", new HttpHandler() {
//            @Override
//            public void handle(HttpExchange exchange) throws IOException {
//                System.exit(0);
//            }
//        });
        ExecutorService executor = Executors.newFixedThreadPool(5);
        server.setExecutor(executor);
        server.start();
    }
}
