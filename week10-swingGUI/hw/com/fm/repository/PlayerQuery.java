package com.fm.repository;

import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerQuery {
    public static List<Player> query(List<Player> players, List<Predicate<Player>> conditions){
        List<Player> ret = players;
        for(Predicate<Player> con : conditions){
            boolean result = con.test(players.get(0));
            ret = ret.stream().filter(con).collect(Collectors.toList());
        }

        return ret;
    }
}
