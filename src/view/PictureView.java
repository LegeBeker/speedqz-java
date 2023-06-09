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
    public PictureView(final ViewController view, final String name, final String letter) {
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image(view.getImagePath(name)));
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        Text letterText = new Text(letter);
        letterText.setFill(Color.WHITE);
        letterText.setStroke(Color.BLACK);
        letterText.setFont(Font.font("Arial", FontWeight.BOLD, 50));

        stackPane.getChildren().addAll(imageView, letterText);

        Text nameText = new Text(name);
        nameText.setFill(Color.WHITE);
        nameText.setStroke(Color.BLACK);
        nameText.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        this.getChildren().addAll(stackPane, nameText);
    }
}
