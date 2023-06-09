package view;

import controller.ViewController;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InputView extends VBox {

    private static final int HEIGHT = 200;
    private static final int WIDTH = 1020;

    private Text first;
    private Text second;
    private Text third;
    private Text fourth;

    public InputView(final ViewController view) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        this.setPrefSize(WIDTH, HEIGHT);
        this.setPadding(new Insets(20));

        Text instructions = new Text(view.getInstructions());
        instructions.setFill(Color.ORANGE);
        instructions.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        HBox input = new HBox();
        input.setSpacing(20);

        first = new Text("_");
        first.setFill(Color.ORANGE);
        first.setStroke(Color.WHITE);
        first.setFont(Font.font("Arial", FontWeight.BOLD, 75));

        second = new Text("_");
        second.setFill(Color.ORANGE);
        second.setStroke(Color.WHITE);
        second.setFont(Font.font("Arial", FontWeight.BOLD, 75));

        third = new Text("_");
        third.setFill(Color.ORANGE);
        third.setStroke(Color.WHITE);
        third.setFont(Font.font("Arial", FontWeight.BOLD, 75));

        fourth = new Text("_");
        fourth.setFill(Color.ORANGE);
        fourth.setStroke(Color.WHITE);
        fourth.setFont(Font.font("Arial", FontWeight.BOLD, 75));

        input.getChildren().addAll(first, second, third, fourth);

        this.getChildren().addAll(instructions, input);

        view.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    if (first.getText().equals("_") || second.getText().equals("_") || third.getText().equals("_")
                            || fourth.getText().equals("_")) {
                        return;
                    }
                    view.setInput(first.getText() + second.getText() + third.getText() + fourth.getText());
                    view.endRound(false);
                    break;
                case BACK_SPACE:
                    if (!fourth.getText().equals("_")) {
                        fourth.setText("_");
                    } else if (!third.getText().equals("_")) {
                        third.setText("_");
                    } else if (!second.getText().equals("_")) {
                        second.setText("_");
                    } else if (!first.getText().equals("_")) {
                        first.setText("_");
                    }
                    break;
                case A:
                case B:
                case C:
                case D:
                    setLetter(e.getCode().toString());
                    break;
                default:
                    break;
            }
        });
    }

    private void setLetter(final String letter) {
        if (first.getText().equals(letter) || second.getText().equals(letter) || third.getText().equals(letter)
                || fourth.getText().equals(letter)) {
            return;
        }

        if (first.getText().equals("_")) {
            first.setText(letter);
        } else if (second.getText().equals("_")) {
            second.setText(letter);
        } else if (third.getText().equals("_")) {
            third.setText(letter);
        } else if (fourth.getText().equals("_")) {
            fourth.setText(letter);
        }
    }
}
