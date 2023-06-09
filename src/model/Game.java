package model;

import java.util.HashMap;
import java.util.Random;

public class Game {

    private int score;
    private int roundnr;

    private HashMap<String, Integer> chosenEntries;
    private String input;

    private DataModel dataModel;

    public Game(String category) {
        this.score = 0;
        this.roundnr = 1;
        this.input = "";
        this.dataModel = new DataModel(category);

        createQuestion();
    }

    public void createQuestion() {
        this.chosenEntries = new HashMap<>();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = rand.nextInt(dataModel.getEntries().size());
            chosenEntries.put((String) dataModel.getEntries().keySet().toArray()[randomIndex],
                    (Integer) dataModel.getEntries().values().toArray()[randomIndex]);
        }
        // TODO - Shuffle the entries

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

    public String getInstructions() {
        return this.dataModel.getInstructions();
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
