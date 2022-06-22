package repository;

import model.GameSinglePlayer;

public interface GameSinglePlayerRepository {
    void create(GameSinglePlayer gameSinglePlayer);

    void delete();

    void readAll();

    void filterGender(String genre);

    void filterPrice(float price);

    void filterRelease(String release);
}
