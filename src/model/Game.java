package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

    private int score;
    private int roundnr;
    private String category;

    private HashMap<String, Integer> chosenEntries;
    private String input;
    private String correctAnswer;

    private DataModel dataModel;

    public Game(String category) {
        this.category = category;
        this.score = 0;
        this.roundnr = 1;
        this.input = "";

        createQuestion();
    }

    public void createQuestion() {
        this.dataModel = new DataModel(this.category);
        this.chosenEntries = getRandomEntries(dataModel.getEntries(), 4);

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

    private HashMap<String, Integer> getRandomEntries(final HashMap<String, Integer> entries, final int amount) {
        HashMap<String, Integer> chosenEntries = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            int randomIndex = random.nextInt(entries.size());
            String randomKey = (String) entries.keySet().toArray()[randomIndex];
            int randomValue = entries.get(randomKey);

            if (!chosenEntries.containsKey(randomKey)) {
                chosenEntries.put(randomKey, randomValue);
            } else {
                i--;
            }
        }

        return chosenEntries;
    }

    public int checkAnswer(final int seconds) {
        if (isCorrect()) {
            return seconds;
        }
        return -seconds;
    }

    public Boolean isCorrect() {
        return this.input.equals(this.correctAnswer);
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
