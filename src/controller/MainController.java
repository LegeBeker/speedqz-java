package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController extends Application {

    private static final int MIN_HEIGHT = 800;
    private static final int MIN_WIDTH = 1280;

    public void startup(final String[] args) {
        launch(args);
    }

    public void start(final Stage stage) {
        ViewController view = new ViewController();

        stage.setTitle("SpeedQZ Volkan Welp");

        stage.setScene(view);

        stage.setMinHeight(MIN_HEIGHT);
        stage.setMinWidth(MIN_WIDTH);

        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.centerOnScreen();
        stage.isAlwaysOnTop();

        stage.show();
    }
}
