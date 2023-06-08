package view;

import controller.ViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WelcomeView extends HBox {

    private static final int BUTTONHEIGHT = 25;
    private static final int BUTTONWIDTH = 200;

    private static final int VBOXSPACING = 10;
    private static final int HBOXSPACING = 20;

    private static final int WRAPPINGWIDTH = 500;

    public WelcomeView(final ViewController view) {
        this.setBackground(view.getBackground());

        VBox leftSide = new VBox();
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setSpacing(VBOXSPACING);

        VBox rightSide = new VBox();
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setSpacing(VBOXSPACING);

        this.setSpacing(HBOXSPACING);
        this.setAlignment(Pos.CENTER);

        Text title = new Text("SpeedQZ");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold;");
        title.setTextAlignment(TextAlignment.CENTER);

        Text description = new Text(
                "SpeedQZ is een quiz waarbij je zo snel mogelijk de vragen moet beantwoorden. Je kan kiezen uit verschillende categorieën. Veel plezier!");
        description.setStyle("-fx-font-size: 20px;");
        description.setTextAlignment(TextAlignment.CENTER);
        description.setWrappingWidth(WRAPPINGWIDTH);

        leftSide.getChildren().addAll(title, description);

        Text titleRight = new Text("Kies een categorie:");
        titleRight.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        titleRight.setTextAlignment(TextAlignment.CENTER);

        Button speedButton = new Button("Snelheid");
        speedButton.setPrefSize(BUTTONWIDTH, BUTTONHEIGHT);
        speedButton.setOnAction(e -> view.openGameView("Speed"));

        Button sizeButton = new Button("Grootte");
        sizeButton.setPrefSize(BUTTONWIDTH, BUTTONHEIGHT);
        sizeButton.setOnAction(e -> view.openGameView("Size"));

        Button mixButton = new Button("Mix");
        mixButton.setPrefSize(BUTTONWIDTH, BUTTONHEIGHT);
        mixButton.setOnAction(e -> view.openGameView("Mix"));

        rightSide.getChildren().addAll(titleRight, speedButton, sizeButton, mixButton);

        this.getChildren().addAll(leftSide, rightSide);
    }
}
