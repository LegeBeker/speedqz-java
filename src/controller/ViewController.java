package controller;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import model.ClockModel;
import model.Game;
import view.BetweenView;
import view.ClockView;
import view.GameView;
import view.WelcomeView;

public class ViewController extends Scene {

    private StackPane rootPane;
    private final Background background;

    private Game game;
    private ClockModel clockModel;
    private ClockView clockView;

    public ViewController() {
        super(new Pane());

        this.rootPane = new StackPane();
        this.setRoot(this.rootPane);

        this.background = new Background(new BackgroundFill(Color.BEIGE, null, null));

        this.openWelcomeView();
    }

    public void changeView(final Pane pane) {
        this.rootPane.getChildren().clear();
        this.rootPane.getChildren().add(pane);
    }

    public Background getBackground() {
        return this.background;
    }

    public void openWelcomeView() {
        changeView(new WelcomeView(this));
    }

    public void openGameView(final String category) {
        this.game = new Game(category);
        startNewClock();
        changeView(new GameView(this, this.clockView));
    }

    public void openGameView() {
        startNewClock();
        changeView(new GameView(this, this.clockView));
    }

    public void startNewClock() {
        this.clockModel = new ClockModel();
        this.clockView = new ClockView(this);
        this.clockView.getArc().lengthProperty().bind(this.clockModel.getArcLength());
        this.clockView.getLabel().textProperty().bind(this.clockModel.getTimer().asString());
        this.clockView.getArc().fillProperty().bind(this.clockModel.getArcColor());

        this.clockModel.getTimer().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 0) {
                endRound();
            }
        });
    }

    public void openBetweenView() {
        changeView(new BetweenView(this));
    }

    public int getRoundNr() {
        return this.game.getRoundNr();
    }

    public int getScore() {
        return this.game.getScore();
    }

    public int getClock() {
        return this.clockModel.getCountdown();
    }

    public void endRound() {
        this.game.endRound();
        openBetweenView();
    }

    public void startNewRound() {
        this.game.startNewRound();
        openGameView();
    }
}
