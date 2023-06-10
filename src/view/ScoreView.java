package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreView extends VBox {

    private static final int SPACING = 20;

    private static final int FONTSIZE = 50;

    public ScoreView(final int roundnr, final int score) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        this.setSpacing(SPACING);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(SPACING));

        Text roundText = new Text("round");
        roundText.setFill(Color.WHITE);
        roundText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        Text roundnrText = new Text(Integer.toString(roundnr));
        roundnrText.setFill(Color.ORANGE);
        roundnrText.setStroke(Color.WHITE);
        roundnrText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        Text scoreText = new Text("score");
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        Text scorenrText = new Text(Integer.toString(score));
        scorenrText.setFill(Color.ORANGE);
        scorenrText.setStroke(Color.WHITE);
        scorenrText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        this.getChildren().addAll(roundText, roundnrText, scoreText, scorenrText);
    }
}
