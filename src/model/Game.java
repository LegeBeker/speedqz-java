package model;

public class Game {

    private int score;
    private int roundnr;
    private String category;

    public Game(String category) {
        this.category = category;
        this.score = 0;
        this.roundnr = 1;
        createQuestion();
    }

    public void createQuestion() {
        // TODO - implement Game.createQuestion
    }

    public int getRoundNr() {
        return this.roundnr;
    }

    public int getScore() {
        return this.score;
    }
}
