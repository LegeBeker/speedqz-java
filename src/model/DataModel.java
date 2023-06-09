package model;

import java.util.HashMap;

import dal.FileIO;

public class DataModel {
    private String category;
    private HashMap<String, Integer> entries;
    private String instructions;

    public DataModel(String category) {
        this.category = category;
        this.entries = FileIO.getCategoryEntries(category);
        this.instructions = FileIO.getInstructions(category);
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
