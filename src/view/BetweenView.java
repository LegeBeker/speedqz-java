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

    private static final Font FONT = Font.font("Arial", FontWeight.BOLD, FONTSIZE);

    public BetweenView(final ViewController view) {
        this.setBackground(view.getBackground());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(SPACING);

        Text correctAnswer = view.isCorrect()
                ? new Text("Correct! Het antwoord was:")
                : new Text("Incorrect, Het juiste antwoord was:");
        correctAnswer.setFont(FONT);

        Text answer = new Text(view.getAnswer());
        answer.setFont(FONT);

        Text title = new Text("Tussenstand:");
        title.setFont(FONT);

        HBox roundAndScoreBox = new HBox();
        roundAndScoreBox.setAlignment(Pos.CENTER);
        roundAndScoreBox.setSpacing(SPACING);

        VBox round = createInfoBox("round", Integer.toString(view.getRoundNr()));
        VBox score = createInfoBox("score", Integer.toString(view.getScore()));

        roundAndScoreBox.getChildren().addAll(round, score);

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

        this.getChildren().addAll(correctAnswer, answer, title, roundAndScoreBox, nextRoundButton);
    }

    private VBox createInfoBox(String label, String value) {
        VBox infoBox = new VBox();
        infoBox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        infoBox.setPadding(new Insets(PADDING));

        Text labelText = new Text(label);
        labelText.setFill(Color.WHITE);
        labelText.setFont(FONT);

        Text valueText = new Text(value);
        valueText.setFill(Color.ORANGE);
        valueText.setStroke(Color.WHITE);
        valueText.setFont(FONT);

        infoBox.setAlignment(Pos.CENTER);
        infoBox.getChildren().addAll(labelText, valueText);

        return infoBox;
    }
}
