package view;

import controller.ViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BetweenView extends VBox {

    private static final int FONTSIZE = 50;

    public BetweenView(final ViewController view) {
        this.setBackground(view.getBackground());
        this.setAlignment(Pos.CENTER);

        HBox info = new HBox();

        VBox round = new VBox();
        Text roundText = new Text("round");
        roundText.setFill(Color.WHITE);
        roundText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        Text roundnrText = new Text(Integer.toString(view.getRoundNr()));
        roundnrText.setFill(Color.ORANGE);
        roundnrText.setStroke(Color.WHITE);
        roundnrText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        round.getChildren().addAll(roundText, roundnrText);

        VBox score = new VBox();
        Text scoreText = new Text("score");
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        Text scorenrText = new Text(Integer.toString(view.getScore()));
        scorenrText.setFill(Color.ORANGE);
        scorenrText.setStroke(Color.WHITE);
        scorenrText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        score.getChildren().addAll(scoreText, scorenrText);

        info.getChildren().addAll(round, score);

        Button nextRoundButton = new Button("Volgende ronde");
        nextRoundButton.setOnAction(e -> view.startNewRound());

        this.getChildren().addAll(info, nextRoundButton);
    }
}
