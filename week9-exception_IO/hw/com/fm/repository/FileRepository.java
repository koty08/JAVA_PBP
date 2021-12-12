package com.fm.repository;

import com.fm.unit.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FileRepository implements IRepository {
    public static final String[] FILE_HEADER =
            { "sofifa_id", "short_name", "height_cm", "nationality", "club", "overall", "player_positions", "\n" };
    private static FileRepository instance = new FileRepository();
    public final String FILENAME =
            Thread.currentThread().getContextClassLoader().getResource("com/fm/repository/players_20_short.csv").getPath();
    private boolean loaded = false;
    private List<Player> players;

    private FileRepository(){
        load();
    }

    private void load() {
        Path path = Paths.get(FILENAME.substring(1));
        String header = String.join(",", FILE_HEADER);
        players = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while((line = br.readLine())!=null){
                if(line.compareTo(header.substring(0, header.length()-2)) == 0){
                    continue;
                }
                players.add(create(line.split(",")));
            }
        } catch (IOException e){
            System.err.println(e);
        } finally {
            loaded = true;
        }
    }

    public static FileRepository getInstance() {return instance;}

    private Player create(String[] fields) {
        return PlayerFactory.createPlayers(fields);
    }

    @Override
    public int count() {
        return players.size();
    }

    @Override
    public void save(Player t) {
        players.add(t);
        Path path = Paths.get(FILENAME.substring(1));
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            for(Player player : players){
                bw.write(player.toString(), 0, player.toString().length());
                bw.newLine();
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    @Override
    public void delete(Player t) {
        players.remove(t);
        Path path = Paths.get(FILENAME.substring(1));
        try(BufferedWriter bw = Files.newBufferedWriter(path)){
            for(Player player : players){
                bw.write(player.toString(), 0, player.toString().length());
                bw.newLine();
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existsById(int id) {
        for(Player player : players){
            if(player.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Player> findAll() {
        Iterable<Player> iterable = players;
        return iterable;
    }

    @Override
    public Optional<Player> findById(int id) {
        for(Player player : players){
            if(player.getId() == id){
                return Optional.of(player);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Player> findByConditions(List<Predicate<Player>> conditions) {
        return PlayerQuery.query(players, conditions);
    }
}
