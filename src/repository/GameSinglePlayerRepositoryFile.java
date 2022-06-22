package repository;

import helpers.Archive;
import model.GameSinglePlayer;

public class GameSinglePlayerRepositoryFile implements GameSinglePlayerRepository {
    private static final String PATH = "db/games.txt";
    Archive archive = new Archive();

    @Override
    public void create(GameSinglePlayer gameSinglePlayer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
    }

    @Override
    public void readAll() {
        // TODO Auto-generated method stub
    }

    @Override
    public void filterGender(String genre) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void filterPrice(float price) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void filterRelease(String release) {
        // TODO Auto-generated method stub
        
    }
}
