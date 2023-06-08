package controller;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import model.Game;
import view.GameView;
import view.WelcomeView;

public class ViewController extends Scene {

    private StackPane rootPane;
    private final Background background;

    private Game game;

    public ViewController() {
        super(new Pane());

        this.rootPane = new StackPane();
        this.setRoot(this.rootPane);

        this.background = new Background(new BackgroundFill(Color.BEIGE, null, null));

        this.openWelcomeView();
    }

    public void changeView(final Pane pane) {
        this.rootPane.getChildren().clear();
        this.rootPane.getChildren().addAll(pane);
    }

    public Background getBackground() {
        return this.background;
    }

    public void openWelcomeView() {
        changeView(new WelcomeView(this));
    }

    public void openGameView(final String category) {
        this.game = new Game(category);
        changeView(new GameView(this));
    }

    public int getRoundNr() {
        return this.game.getRoundNr();
    }

    public int getScore() {
        return this.game.getScore();
    }
}
