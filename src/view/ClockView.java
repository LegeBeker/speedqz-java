package view;

import controller.ViewController;
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

    private static final int HEIGHT = 200;

    private static final int ARCRADIUS = 100;
    private static final int ARCDEGREE = 90;

    private static final int FONTSIZE = 50;

    private static final int FULLCIRCLE = 360;

    private Label label;
    private Arc arc;

    public ClockView(final ViewController view) {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        this.setPrefHeight(HEIGHT);

        arc = new Arc(ARCRADIUS, ARCRADIUS, ARCRADIUS, ARCRADIUS, ARCDEGREE, FULLCIRCLE);
        arc.setType(ArcType.ROUND);

        label = new Label();
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Arial", FontWeight.BOLD, FONTSIZE));

        label.layoutXProperty().bind(this.widthProperty().subtract(label.widthProperty()).divide(2));
        label.layoutYProperty().bind(this.heightProperty().subtract(label.heightProperty()).divide(2));

        this.getChildren().addAll(arc, label);
    }

    public Label getLabel() {
        return this.label;
    }

    public Arc getArc() {
        return this.arc;
    }
}
