package dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public final class FileIO {

    private FileIO() {
    }

    public static HashMap<String, Integer> getCategoryEntries(final String category) {
        HashMap<String, Integer> map = new HashMap<>();

        try (BufferedReader reader = getReader(category)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    throw new IncorrectCatFileException("Line does not contain 2 arguments");
                }
                String fullName = parts[0];
                if (fullName.isEmpty()) {
                    throw new IncorrectCatFileException("First argument is empty");
                }
                int value;
                try {
                    value = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    throw new IncorrectCatFileException("Second argument is not an integer");
                }

                map.put(fullName, value);
            }
        } catch (IOException | IncorrectCatFileException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getInstructions(final String category) {
        String instructions = "";

        try (BufferedReader reader = getReader(category)) {
            instructions = reader.readLine();
            if (instructions.isEmpty()) {
                throw new IncorrectCatFileException("Instruction is empty");
            }
        } catch (IOException | IncorrectCatFileException e) {
            e.printStackTrace();
        }
        return instructions;
    }

    public static BufferedReader getReader(final String category) {
        String categoryFile = "/files/cat_" + category + ".txt";
        String path = FileIO.class.getResource(categoryFile).getPath();
        java.io.File file = new File(path);

        try {
            return new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
