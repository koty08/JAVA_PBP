package com.fm.repository;

import com.fm.game.SearchCondition;
import com.fm.unit.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerSearchPredicateFactory {
    public static List<Predicate<Player>> makeConditions(List<SearchCondition> searchConditions){
        List<Predicate<Player>> predicateList = new ArrayList<>();

        for(SearchCondition condition : searchConditions){
            switch (condition.getField()){
                case "name":
                    predicateList.add((p) -> p.getName().contains(condition.getCondition()));
                    break;
                case "club":
                    predicateList.add((p) -> p.getClub().contains(condition.getCondition()));
                    break;
                case "nationality":
                    predicateList.add((p) -> p.getNationality().contains(condition.getCondition()));
                    break;
                case "position":
                    predicateList.add((p) -> p.getPositions().contains(condition.getCondition()));
                    break;
            }
        }
        return predicateList;
    }
}
