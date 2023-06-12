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
    private static final Font FONT = Font.font("Arial", FontWeight.BOLD, FONTSIZE);

    public ScoreView(final int roundnr, final int score) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        this.setSpacing(SPACING);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(SPACING));

        Text roundText = createTitle("round");
        Text roundnrText = createValue(Integer.toString(roundnr));

        Text scoreText = createTitle("score");
        Text scorenrText = createValue(Integer.toString(score));

        this.getChildren().addAll(roundText, roundnrText, scoreText, scorenrText);
    }

    private Text createTitle(String text) {
        Text title = new Text(text);
        title.setFill(Color.WHITE);
        title.setFont(FONT);
        return title;
    }

    private Text createValue(String text) {
        Text value = new Text(text);
        value.setFill(Color.ORANGE);
        value.setStroke(Color.WHITE);
        value.setFont(FONT);
        return value;
    }
}
