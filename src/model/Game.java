package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

    private int score;
    private int roundnr;

    private HashMap<String, Integer> chosenEntries;
    private String input;
    private String correctAnswer;

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
            int randomIndex = rand.nextInt(dataModel.getEntries().size() - 1);
            chosenEntries.put((String) dataModel.getEntries().keySet().toArray()[randomIndex],
                    (Integer) dataModel.getEntries().values().toArray()[randomIndex]);
        }

        HashMap<Character, Integer> entryMap = new HashMap<>();

        for (int i = 0; i < chosenEntries.size(); i++) {
            entryMap.put((char) (i + 65), (Integer) chosenEntries.values().toArray()[i]);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entryMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        StringBuilder correctAnswerBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            correctAnswerBuilder.append(entry.getKey());
        }

        this.correctAnswer = correctAnswerBuilder.toString();
    }

    public int checkAnswer(final int seconds) {
        if (this.input.equals(this.correctAnswer)) {
            return seconds;
        }
        return -seconds;
    }

    public void endRound(final int seconds) {
        this.score += checkAnswer(seconds);
    }

    public void startNewRound() {
        this.roundnr++;
        createQuestion();
    }

    public String getInstructions() {
        return this.dataModel.getInstructions();
    }

    public HashMap<String, Integer> getChosenEntries() {
        return this.chosenEntries;
    }

    public int getRoundNr() {
        return this.roundnr;
    }

    public String getCategory() {
        return this.dataModel.getCategory();
    }

    public int getScore() {
        return this.score;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getAnswer() {
        return this.correctAnswer;
    }
}
