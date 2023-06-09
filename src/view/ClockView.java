package view;

import controller.ViewController;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ClockView extends Pane {

    private static final int COUNTDOWN = 30;
    private static final int ARCRADIUS = 100;
    private static final int ARCDEGREE = 90;

    private static final int FONTSIZE = 50;
    private static final int SECOND = 1000;

    private static final int FULLCIRCLE = 360;

    public ClockView(final ViewController view) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Arc arc = new Arc(ARCRADIUS, ARCRADIUS, ARCRADIUS, ARCRADIUS, ARCDEGREE, FULLCIRCLE);
        arc.setType(ArcType.ROUND);

        this.getChildren().addAll(arc);

        Label label = new Label();
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        // Center the label
        label.layoutXProperty().bind(this.widthProperty().subtract(label.widthProperty()).divide(2));
        label.layoutYProperty().bind(this.heightProperty().subtract(label.heightProperty()).divide(2));

        this.getChildren().add(label);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = COUNTDOWN; i >= 0; i--) {
                    updateMessage(String.valueOf(i));
                    arc.setLength(FULLCIRCLE - (COUNTDOWN - i) * (FULLCIRCLE / COUNTDOWN));
                    if (i == COUNTDOWN) {
                        arc.setFill(Color.GREEN);
                    } else if (i == (COUNTDOWN / 2)) {
                        arc.setFill(Color.YELLOW);
                    } else if (i == 9) {
                        arc.setFill(Color.ORANGE);
                    } else if (i == 2) {
                        arc.setFill(Color.RED);
                    }
                    Thread.sleep(SECOND);
                }
                view.openBetweenView();
                return null;
            }
        };

        label.textProperty().bind(task.messageProperty());

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();

    }
}
