package model;

import java.util.UUID;

/**
 * Entidade que representa um jogo single player
 */
public class GameSinglePlayer implements Game {
    private String uuid;
    private String name;
    private Integer type;
    private Float price;
    private String releaseYear;
    private String genre;

    public GameSinglePlayer(String _name, float _price, String _releaseYear, String _genre){
        this.uuid = UUID.randomUUID().toString();
        this.name = _name;
        this.price = _price;
        this.releaseYear = _releaseYear;
        this.genre = _genre;
    }

    public GameSinglePlayer(String _uuid, String _name, float _price, String _releaseYear, String _genre){
        this.uuid = _uuid;
        this.name = _name;
        this.price = _price;
        this.releaseYear = _releaseYear;
        this.genre = _genre;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getType() {
        return 1; // Sempre que um jogo for single player o tipo será 1.
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

    /**
     * @return String return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @param releaseYear the releaseYear to set
     */
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return this.uuid + "\t" + this.name + "\t" + this.price + "\t" + this.releaseYear + "\t" + this.genre;
    }
}
