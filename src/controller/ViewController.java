package controller;

import java.util.Map;

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

        background = new Background(new BackgroundFill(Color.BEIGE, null, null));

        openWelcomeView();
    }

    public void setView(final Pane pane) {
        setOnKeyPressed(null);
        setRoot(pane);
    }

    public Background getBackground() {
        return background;
    }

    public void openWelcomeView() {
        setView(new WelcomeView(this));
    }

    public void openEndView() {
        setView(new EndView(this));
    }

    public void startNewGame(final String category) {
        game = new Game(category);
        startNewRound();
    }

    public void openGameView() {
        startNewClock();
        setRoot(new GameView(this, clockView));
    }

    public void startNewClock() {
        clockModel = new ClockModel();
        clockView = new ClockView(this);
        clockView.getArc().lengthProperty().bind(clockModel.getArcLength());
        clockView.getLabel().textProperty().bind(clockModel.getTimer().asString());
        clockView.getArc().fillProperty().bind(clockModel.getArcColor());

        clockModel.getTimer().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 0) {
                endRound(true);
            }
        });
    }

    public void openBetweenView() {
        setView(new BetweenView(this));
    }

    public int getRoundNr() {
        return game.getRoundNr();
    }

    public int getScore() {
        return game.getScore();
    }

    public String getInstructions() {
        return game.getInstructions();
    }

    public Map<String, Integer> getChosenEntries() {
        return game.getChosenEntries();
    }

    public void setInput(final String input) {
        game.setInput(input);
    }

    public Boolean isCorrect() {
        return game.isCorrect();
    }

    public void endRound(final Boolean timeOut) {
        if (!timeOut) {
            clockModel.stop();
            game.endRound(clockModel.getCountdown());
        }
        if (game.getRoundNr() == 10) {
            openEndView();
            return;
        }
        openBetweenView();
    }

    public void startNewRound() {
        game.startNewRound();
        openGameView();
    }

    public String getImagePath(String name) {
        return "file:resources/pics/" + game.getCategory() + "/" + name + ".jpg";
    }

    public String getAnswer() {
        return game.getAnswer();
    }
}
