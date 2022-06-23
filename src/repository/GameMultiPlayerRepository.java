package repository;

import model.GameMultiplayer;

public interface GameMultiPlayerRepository {
    void create(GameMultiplayer gameMultiPlayer);

    void delete();

    void readAll();

    void filterGender(String genre);

    void filterPrice(float price);

    void filterRelease(String release);
}
