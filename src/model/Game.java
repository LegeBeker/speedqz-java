package model;

public class Game {

    private int score;
    private int roundnr;
    private String category;

    private String[] pictures;
    private String input;

    public Game(String category) {
        this.category = category;
        this.score = 0;
        this.roundnr = 1;
        this.pictures = new String[4];
        createQuestion();
    }

    public void createQuestion() {
        // TODO - implement Game.createQuestion
    }

    public int checkAnswer() {
        // TODO - implement Game.checkAnswer
        return 0;
    }

    public void endRound() {
        int points = checkAnswer();
        this.score += points;
    }

    public void startNewRound() {
        this.roundnr++;
        createQuestion();
    }

    public int getRoundNr() {
        return this.roundnr;
    }

    public int getScore() {
        return this.score;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
