package model;

import java.util.Map;
import java.util.Random;

import dal.FileIO;

public class DataModel {
    private static final String[] CATEGORIES = {
            "speed",
            "paintings",
            "buildings"
    };

    private String category;
    private Map<String, Integer> entries;
    private String instructions;

    public DataModel(final String category) {
        this.category = category;
        if (category.equals("mix")) {
            Random random = new Random();
            int randomIndex = random.nextInt(CATEGORIES.length);
            this.category = CATEGORIES[randomIndex];
        }
        entries = FileIO.getCategoryEntries(this.category);
        instructions = FileIO.getInstructions(this.category);
    }

    public String getCategory() {
        return category;
    }

    public Map<String, Integer> getEntries() {
        return entries;
    }

    public String getInstructions() {
        return instructions;
    }
}
