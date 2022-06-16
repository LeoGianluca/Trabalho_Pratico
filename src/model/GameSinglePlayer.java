package model;

public class GameSinglePlayer implements Game {
    String name;
    Integer type;
    Float price;
    String releaseYear;
    String genre;

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer getType() {
        // Sempre que um jogo for cadastrado como single player, o tipo será 1.
        return 1;
    }

    @Override
    public Float getPrice() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getReleaseYear() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getGenre() {
        // TODO Auto-generated method stub
        return null;
    }
}
