package model;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ClockModel extends Task<Void> {

    private static final int COUNTDOWN = 30;
    private static final int FULLCIRCLE = 360;

    private IntegerProperty timer = new SimpleIntegerProperty(COUNTDOWN);
    private IntegerProperty arcLength = new SimpleIntegerProperty(FULLCIRCLE);

    public ClockModel() {
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public IntegerProperty getTimer() {
        return timer;
    }

    public IntegerProperty getArcLength() {
        return arcLength;
    }

    public ObjectBinding<Paint> getArcColor() {
        return Bindings.createObjectBinding(() -> {
            double red = 1 - ((double) timer.get() / COUNTDOWN);
            double green = (double) timer.get() / COUNTDOWN;
            return Color.color(red, green, 0);
        }, timer);
    }

    public int getCountdown() {
        return timer.get();
    }

    public void stop() {
        cancel();
    }

    @Override
    protected Void call() throws Exception {
        for (int i = COUNTDOWN; i >= 0; i--) {
            int finalI = i;
            Platform.runLater(() -> {
                timer.set(finalI);
                arcLength.set((int) (FULLCIRCLE * ((double) finalI / COUNTDOWN)));

            });
            Thread.sleep(1000);
        }
        return null;
    }
}
