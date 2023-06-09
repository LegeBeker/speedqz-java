package view;

import java.util.HashMap;

import controller.ViewController;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PicturesView extends GridPane {

    private static final int HEIGHT = 520;
    private static final int WIDTH = 1020;

    public PicturesView(final ViewController view) {
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        this.setHgap(20);
        this.setVgap(20);

        this.setPrefSize(WIDTH, HEIGHT);

        HashMap<String, Integer> chosenEntries = view.getChosenEntries();

        Character c = 'A';
        for (String key : chosenEntries.keySet()) {
            PictureView pictureView = new PictureView(view, key, c.toString());
            if (c == 'A' || c == 'B') {
                this.add(pictureView, c - 'A', 0);
            } else {
                this.add(pictureView, c - 'C', 1);
            }
            c++;
        }

        this.setAlignment(Pos.CENTER);
    }
}
