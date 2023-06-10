package view;

import controller.ViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EndView extends VBox {

    private static final int FONTSIZE = 50;
    private static final int SPACING = 50;

    public EndView(final ViewController view) {
        this.setBackground(view.getBackground());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(SPACING);

        Text title = new Text("Het spel is afgelopen!");
        title.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        Text score = new Text("Je hebt " + view.getScore() + " punten behaald!");
        score.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        Button endButton = new Button("Afsluiten");
        endButton.setOnAction(e -> System.exit(0));

        this.setOnKeyPressed(e -> {
            System.exit(0);
        });

        this.getChildren().addAll(title, score, endButton);
    }
}
