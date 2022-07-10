package automat;

import java.util.Objects;

public class Game {
    private String gameTitle;
    private int gamePrice;

    public Game(String gameTitle, int gamePrice) {
        this.gameTitle = gameTitle;
        this.gamePrice = gamePrice;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public int getGamePrice() {
        return gamePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gamePrice == game.gamePrice && Objects.equals(gameTitle, game.gameTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameTitle, gamePrice);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameTitle='" + gameTitle + '\'' +
                ", gamePrice=" + gamePrice +
                '}';
    }
}
