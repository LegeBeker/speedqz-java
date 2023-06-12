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

    private static final Font INSTRUCTIONSFONT = Font.font("Arial", FontWeight.BOLD, 20);
    private static final Font INPUTFONT = Font.font("Arial", FontWeight.BOLD, 75);

    private static final int SPACING = 20;

    private Text first;
    private Text second;
    private Text third;
    private Text fourth;

    public InputView(final ViewController view) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        this.setPadding(new Insets(SPACING));

        Text instructions = new Text(view.getInstructions());
        instructions.setFill(Color.ORANGE);
        instructions.setFont(INSTRUCTIONSFONT);

        HBox input = new HBox();
        input.setSpacing(SPACING);

        first = createInputText();
        second = createInputText();
        third = createInputText();
        fourth = createInputText();

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

    private Text createInputText() {
        Text t = new Text("_");
        t.setFill(Color.ORANGE);
        t.setStroke(Color.WHITE);
        t.setFont(INPUTFONT);
        return t;
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
