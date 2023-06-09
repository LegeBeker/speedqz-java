package view;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class PicturesView extends TilePane {

    private static final int HEIGHT = 520;
    private static final int WIDTH = 1020;

    public PicturesView() {
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        this.setPrefSize(WIDTH, HEIGHT);

        // TODO
    }
}
