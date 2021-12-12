package com.fm.repository;

import com.fm.unit.Player;

import java.util.Arrays;

public class PlayerFactory {
    public static Player createPlayersWithoutID(String[] fields){
        String pos_str = "";
        for(int i = 5; i < fields.length; i++){
            if(fields[i].compareTo(" ") == 0){
                continue;
            }
            pos_str += fields[i].replace("\"", "").strip();
            pos_str += " ";
        }
        Player p = new Player(fields[0], Integer.parseInt(fields[1]), fields[2], fields[3], Integer.parseInt(fields[4]), Arrays.asList(pos_str.split(" ")));

        return p;
    }

    public static Player createPlayers(String[] fields){
        String pos_str = "";
        for(int i = 6; i < fields.length; i++){
            if(fields[i].compareTo(" ") == 0){
                continue;
            }
            pos_str += fields[i].replace("\"", "").strip();
            pos_str += " ";
        }
        Player p = new Player(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), fields[3], fields[4], Integer.parseInt(fields[5]), Arrays.asList(pos_str.split(" ")));

        return p;
    }
}
