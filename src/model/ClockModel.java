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

    private IntegerProperty timer;
    private IntegerProperty arcLength;

    public ClockModel() {
        this.timer = new SimpleIntegerProperty(COUNTDOWN);
        this.arcLength = new SimpleIntegerProperty(FULLCIRCLE);
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public IntegerProperty getTimer() {
        return this.timer;
    }

    public IntegerProperty getArcLength() {
        return this.arcLength;
    }

    public ObjectBinding<Paint> getArcColor() {
        return Bindings.createObjectBinding(() -> {
            double red = 1 - ((double) this.timer.get() / COUNTDOWN);
            double green = (double) this.timer.get() / COUNTDOWN;
            return Color.color(red, green, 0);
        }, this.timer);
    }

    public int getCountdown() {
        return this.timer.get();
    }

    public void stop() {
        cancel();
    }

    @Override
    protected Void call() throws Exception {
        for (int i = COUNTDOWN; i >= 0; i--) {
            int finalI = i;
            Platform.runLater(() -> {
                updateMessage(String.valueOf(finalI));
                this.timer.set(finalI);
                this.arcLength.set((int) (FULLCIRCLE * ((double) finalI / COUNTDOWN)));

            });
            Thread.sleep(1000);
        }
        return null;
    }
}
