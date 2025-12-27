package org.webservice.api.domain.core;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class GamesDto {
    private Long gameId;
    @NotBlank(message = "{game.title.required}")
    private String gameTitle;
    @NotBlank(message = "{NotBlank}")
    private String gameDescription;
    @NotNull(message = "{NotNull}")
    private Long gameGenre;
    @NotNull(message = "{NotNull}")
    private Long gamePlatform;
    @NotBlank(message = "{NotBlank}")
    private String gameDeveloper;
    @NotBlank(message = "{NotBlank}")
    private String gameClassification;
    private Date releaseDate;
    @NotNull(message = "{NotNull}")
    @Min(value = 1,message = "{Min}")
    private Integer price;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
