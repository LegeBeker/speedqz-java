package controller;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.ClockModel;
import model.Game;
import view.BetweenView;
import view.ClockView;
import view.EndView;
import view.GameView;
import view.WelcomeView;

public class ViewController extends Scene {

    private final Background background;

    private Game game;
    private ClockModel clockModel;
    private ClockView clockView;

    public ViewController() {
        super(new Pane());

        this.background = new Background(new BackgroundFill(Color.BEIGE, null, null));

        this.openWelcomeView();
    }

    public Background getBackground() {
        return this.background;
    }

    public void openWelcomeView() {
        this.setRoot(new WelcomeView(this));
    }

    public void openEndView() {
        this.setRoot(new EndView(this));
    }

    public void openGameView(final String category) {
        this.game = new Game(category);
        startNewClock();
        this.setRoot(new GameView(this, this.clockView));
    }

    public void openGameView() {
        startNewClock();
        this.setRoot(new GameView(this, this.clockView));
    }

    public void startNewClock() {
        this.clockModel = new ClockModel();
        this.clockView = new ClockView(this);
        this.clockView.getArc().lengthProperty().bind(this.clockModel.getArcLength());
        this.clockView.getLabel().textProperty().bind(this.clockModel.getTimer().asString());
        this.clockView.getArc().fillProperty().bind(this.clockModel.getArcColor());

        this.clockModel.getTimer().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 0) {
                endRound(true);
            }
        });
    }

    public void openBetweenView() {
        this.setRoot(new BetweenView(this));
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

    public String getInstructions() {
        return this.game.getInstructions();
    }

    public HashMap<String, Integer> getChosenEntries() {
        return this.game.getChosenEntries();
    }

    public void setInput(final String input) {
        this.game.setInput(input);
    }

    public Boolean isCorrect() {
        return this.game.isCorrect();
    }

    public void endRound(final Boolean timeOut) {
        if (!timeOut) {
            this.clockModel.stop();
            this.game.endRound(this.clockModel.getCountdown());
        }
        if (this.game.getRoundNr() == 1) {
            openEndView();
            return;
        }
        openBetweenView();
    }

    public void startNewRound() {
        this.game.startNewRound();
        openGameView();
    }

    public String getImagePath(String name) {
        return "file:resources/pics/" + this.game.getCategory() + "/" + name + ".jpg";
    }

    public String getAnswer() {
        return this.game.getAnswer();
    }
}
