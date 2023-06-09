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
            if (this.timer.get() > 15) {
                return Color.GREEN;
            } else if (this.timer.get() > 9) {
                return Color.YELLOW;
            } else if (this.timer.get() > 2) {
                return Color.ORANGE;
            } else {
                return Color.RED;
            }
        }, this.timer);
    }

    public String getCountdownString() {
        return String.valueOf(this.timer.get());
    }

    public int getCountdown() {
        return this.timer.get();
    }

    public void reset() {
        cancel();
        this.timer.set(COUNTDOWN);
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
