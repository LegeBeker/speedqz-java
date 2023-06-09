package view;

import controller.ViewController;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class InputView extends VBox {

    private static final int HEIGHT = 200;
    private static final int WIDTH = 1020;

    public InputView(final ViewController view) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        this.setPrefSize(WIDTH, HEIGHT);

        this.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    view.endRound();
                    break;
                default:
                    break;
            }
        });
    }
}
