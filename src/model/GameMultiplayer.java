package model;

/**
 * Entidade que representa um jogo multiplayer
 */
public class GameMultiplayer implements Game {

    private String name;
    private Integer type;
    private Float price;
    private String releaseYear;
    private String genre;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getType() {
        return 1; // Sempre que um jogo for multiplayer o tipo será 2. {???}
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String getReleaseYear() {
        return this.releaseYear;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }

}
