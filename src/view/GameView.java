package view;

import controller.ViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GameView extends HBox {

    private static final int LEFTSIDEWIDTH = 200;
    private static final int SPACING = 20;

    public GameView(final ViewController view, final ClockView clockView) {
        this.setBackground(view.getBackground());
        this.setSpacing(SPACING);
        this.setPadding(new Insets(SPACING));

        VBox leftSide = new VBox();
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setSpacing(SPACING);
        leftSide.setPrefWidth(LEFTSIDEWIDTH);

        VBox rightSide = new VBox();
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setSpacing(SPACING);

        ScoreView scoreView = new ScoreView(view.getRoundNr(), view.getScore());
        scoreView.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(scoreView, Priority.ALWAYS);

        leftSide.getChildren().addAll(clockView, scoreView);

        PicturesView picturesView = new PicturesView(view);
        InputView inputView = new InputView(view);

        VBox.setVgrow(picturesView, Priority.ALWAYS);

        rightSide.getChildren().addAll(picturesView, inputView);
        HBox.setHgrow(rightSide, Priority.ALWAYS);

        this.getChildren().addAll(leftSide, rightSide);
    }
}
