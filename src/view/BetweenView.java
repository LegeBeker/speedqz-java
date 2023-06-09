package view;

import controller.ViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BetweenView extends VBox {

    private static final int FONTSIZE = 50;
    private static final int SPACING = 50;
    private static final int PADDING = 10;

    public BetweenView(final ViewController view) {
        this.setBackground(view.getBackground());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(SPACING);

        Text correctAnswer;
        if (view.isCorrect()) {
            correctAnswer = new Text("Correct! Het antwoord was:");
        } else {
            correctAnswer = new Text("Incorrect, Het juiste antwoord was:");
        }
        correctAnswer.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        Text answer = new Text(view.getAnswer());
        answer.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        Text title = new Text("Tussenstand:");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        HBox info = new HBox();
        info.setAlignment(Pos.CENTER);
        info.setSpacing(SPACING);

        VBox round = new VBox();
        round.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        round.setPadding(new Insets(PADDING));
        Text roundText = new Text("round");
        roundText.setFill(Color.WHITE);
        roundText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        Text roundnrText = new Text(Integer.toString(view.getRoundNr()));
        roundnrText.setFill(Color.ORANGE);
        roundnrText.setStroke(Color.WHITE);
        roundnrText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        round.setAlignment(Pos.CENTER);
        round.getChildren().addAll(roundText, roundnrText);

        VBox score = new VBox();
        score.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        score.setPadding(new Insets(PADDING));
        Text scoreText = new Text("score");
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        Text scorenrText = new Text(Integer.toString(view.getScore()));
        scorenrText.setFill(Color.ORANGE);
        scorenrText.setStroke(Color.WHITE);
        scorenrText.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));
        score.setAlignment(Pos.CENTER);
        score.getChildren().addAll(scoreText, scorenrText);

        info.getChildren().addAll(round, score);

        Button nextRoundButton = new Button("Volgende ronde");
        nextRoundButton.setOnAction(e -> view.startNewRound());

        this.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    view.startNewRound();
                    break;
                default:
                    break;
            }
        });

        this.getChildren().addAll(correctAnswer, answer, title, info, nextRoundButton);
    }
}
