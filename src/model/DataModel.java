package model;

import java.util.HashMap;

import dal.FileIO;

public class DataModel {
    private static String[] categories = {
            "speed",
            "paintings",
            "buildings"
    };

    private String category;
    private HashMap<String, Integer> entries;
    private String instructions;

    public DataModel(final String category) {
        this.category = category;
        if (category.equals("mix")) {
            int randomIndex = (int) (Math.random() * categories.length);
            this.category = categories[randomIndex];
        }
        this.entries = FileIO.getCategoryEntries(this.category);
        this.instructions = FileIO.getInstructions(this.category);
    }

    public String getCategory() {
        return this.category;
    }

    public HashMap<String, Integer> getEntries() {
        return this.entries;
    }

    public String getInstructions() {
        return this.instructions;
    }
}
