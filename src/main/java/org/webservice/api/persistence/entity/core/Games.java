package org.webservice.api.persistence.entity.core;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "games_info")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_title")
    private String gameTitle;

    @Column(name = "game_description")
    private String gameDescription;

    @Column(name = "game_genre")
    private Long gameGenre;

    @Column(name = "game_platform")
    private Long gamePlatform;

    @Column(name = "game_developer")
    private String gameDeveloper;

    @Column(name = "game_age_classification")
    private String gameClassification;

    @Column(name = "game_release_date")
    private Date releaseDate;

    @Column(name = "game_price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "game_genre",insertable = false,updatable = false)
    private Genres genre;

    @ManyToOne
    @JoinColumn(name = "game_platform",insertable = false,updatable = false)
    private Platforms platform;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public Long getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(Long gameGenre) {
        this.gameGenre = gameGenre;
    }

    public Long getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(Long gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public String getGameClassification() {
        return gameClassification;
    }

    public void setGameClassification(String gameClassification) {
        this.gameClassification = gameClassification;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public Platforms getPlatform() {
        return platform;
    }

    public void setPlatform(Platforms platform) {
        this.platform = platform;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
