package model;

import java.util.UUID;

/**
 * Entidade que representa um jogo multiplayer
 */
public class GameMultiplayer implements Game {
    private String uuid;
    private String name;
    private Integer type;
    private Float price;
    private String releaseYear;
    private String genre;
    private Integer maxPlayers;

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public GameMultiplayer(String _name, float _price, String _releaseYear, String _genre, Integer _maxPlayers) {
        this.uuid = UUID.randomUUID().toString();
        this.name = _name;
        this.price = _price;
        this.releaseYear = _releaseYear;
        this.genre = _genre;
        this.maxPlayers = _maxPlayers;
    }

    public GameMultiplayer(String _uuid, String _name, float _price, String _releaseYear, String _genre, Integer _maxPlayers) {
        this.uuid = _uuid;
        this.name = _name;
        this.price = _price;
        this.releaseYear = _releaseYear;
        this.genre = _genre;
        this.maxPlayers = _maxPlayers;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getType() {
        return 2; // Sempre que um jogo for multiplayer o tipo será 2
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
        return this.uuid + "\t" + this.name + "\t" + this.price + "\t" + this.releaseYear + "\t" + this.genre + "\t" + this.maxPlayers;
    }

}
