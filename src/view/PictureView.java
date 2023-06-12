package view;

import controller.ViewController;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PictureView extends VBox {

    private static final int HEIGHT = 200;

    private static final Font LETTERFONT = Font.font("Arial", FontWeight.BOLD, 50);
    private static final Font NAMEFONT = Font.font("Arial", FontWeight.BOLD, 30);

    public PictureView(final ViewController view, final String name, final String letter) {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(view.getImagePath(name)));
        imageView.setFitHeight(HEIGHT);
        imageView.setPreserveRatio(true);

        Text letterText = new Text(letter);
        letterText.setFill(Color.WHITE);
        letterText.setStroke(Color.BLACK);
        letterText.setFont(LETTERFONT);

        stackPane.getChildren().addAll(imageView, letterText);

        Text nameText = new Text(name.replace("_", " "));
        nameText.setFill(Color.WHITE);
        nameText.setStroke(Color.BLACK);
        nameText.setFont(NAMEFONT);

        this.getChildren().addAll(stackPane, nameText);
    }
}
