package com.fm.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fm.unit.Player;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerClient {
    public static void main(String[] args){
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
        Scanner sc = new Scanner(System.in);
        String params = "";
        int count = 0;
        String line = sc.nextLine();
        String[] temp = line.split(" ");
        for(String str : temp){
            if(count == temp.length-1){
                params = params + str;
                break;
            }
            if(count % 2 == 1){
                params = params + str + "&";
            }
            else{
                params = params + str + "=";
            }
            count++;
        }
//        System.out.println("sending requests..");
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:9000/players?" + params)).timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json").GET().build();

        ObjectMapper mapper = new ObjectMapper();
        List<String> responseBody;
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                CollectionType playerListType = mapper.getTypeFactory().constructCollectionType(List.class, Player.class);
                responseBody = mapper.readValue(response.body(), playerListType);
                System.out.println(responseBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}