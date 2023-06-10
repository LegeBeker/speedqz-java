package view;

import controller.ViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GameView extends HBox {

    private static final int HEIGHT = 200;
    private static final int SPACING = 20;

    public GameView(final ViewController view, final ClockView clock) {
        this.setBackground(view.getBackground());
        this.setSpacing(SPACING);
        this.setPadding(new Insets(SPACING));

        VBox leftSide = new VBox();
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setSpacing(SPACING);

        leftSide.setPrefWidth(HEIGHT);

        VBox rightSide = new VBox();
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setSpacing(SPACING);

        clock.setPrefHeight(HEIGHT);

        ScoreView score = new ScoreView(view.getRoundNr(), view.getScore());
        score.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(score, Priority.ALWAYS);

        leftSide.getChildren().addAll(clock, score);

        PicturesView pictures = new PicturesView(view);
        InputView input = new InputView(view);

        VBox.setVgrow(pictures, Priority.ALWAYS);

        rightSide.getChildren().addAll(pictures, input);
        HBox.setHgrow(rightSide, Priority.ALWAYS);

        this.getChildren().addAll(leftSide, rightSide);
    }
}
