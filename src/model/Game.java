package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

    public static final int AMOUNT_OF_ROUNDS = 10;

    private static final int AMOUNT_OF_ENTRIES = 4;
    private static final int ASCII_VALUE_A = 65;

    private int score = 0;
    private int roundnr = 0;
    private String category;

    private Map<String, Integer> chosenEntries;
    private String input = "";
    private String correctAnswer;

    private DataModel dataModel;

    public Game(final String category) {
        this.category = category;
    }

    public void createQuestion() {
        dataModel = new DataModel(category);
        chosenEntries = getRandomEntries(dataModel.getEntries(), AMOUNT_OF_ENTRIES);

        HashMap<Character, Integer> entryMap = new HashMap<>();

        int index = ASCII_VALUE_A;
        for (String entryKey : chosenEntries.keySet()) {
            entryMap.put((char) index++, (Integer) chosenEntries.get(entryKey));
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(entryMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        StringBuilder correctAnswerBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            correctAnswerBuilder.append(entry.getKey());
        }

        correctAnswer = correctAnswerBuilder.toString();
    }

    private Map<String, Integer> getRandomEntries(final Map<String, Integer> entries, final int amount) {
        Map<String, Integer> chosenEntries = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            int randomIndex = random.nextInt(entries.size());
            String randomKey = (String) entries.keySet().toArray()[randomIndex];
            int randomValue = entries.get(randomKey);

            if (!chosenEntries.containsKey(randomKey) && !chosenEntries.containsValue(randomValue)) {
                chosenEntries.put(randomKey, randomValue);
            } else {
                i--;
            }
        }

        return chosenEntries;
    }

    public int checkAnswer(final int seconds) {
        return isCorrect() ? seconds : -seconds;
    }

    public Boolean isCorrect() {
        return input.equals(correctAnswer);
    }

    public void endRound(final int seconds) {
        score += checkAnswer(seconds);
    }

    public void startNewRound() {
        roundnr++;
        createQuestion();
    }

    public String getInstructions() {
        return dataModel.getInstructions();
    }

    public Map<String, Integer> getChosenEntries() {
        return chosenEntries;
    }

    public int getRoundNr() {
        return roundnr;
    }

    public String getCategory() {
        return dataModel.getCategory();
    }

    public int getScore() {
        return score;
    }

    public void setInput(final String input) {
        this.input = input;
    }

    public String getAnswer() {
        return correctAnswer;
    }
}
