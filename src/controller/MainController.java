package controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {

    private static final int MINHEIGHT = 800;
    private static final int MINWIDTH = 1280;

    public void startup(final String[] args) {
        launch(args);
    }

    public void start(final Stage stage) {
        ViewController view = new ViewController();

        stage.setTitle("SpeedQZ Volkan Welp");

        stage.setScene(view);

        stage.setMinHeight(MINHEIGHT);
        stage.setMinWidth(MINWIDTH);

        stage.setResizable(false);
        stage.setFullScreen(true);

        stage.centerOnScreen();
        stage.isAlwaysOnTop();

        stage.show();
    }
}
