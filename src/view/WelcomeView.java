package view;

import controller.ViewController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WelcomeView extends HBox {

    private static final int BUTTONHEIGHT = 25;
    private static final int BUTTONWIDTH = 200;

    private static final int VBOXSPACING = 10;
    private static final int HBOXSPACING = 20;

    private static final int WRAPPINGWIDTH = 500;

    private static final Font TITLEFONT = Font.font("Arial", FontWeight.BOLD, 50);
    private static final Font FONT = Font.font("Arial", FontWeight.BOLD, 30);

    private ViewController view;

    public WelcomeView(final ViewController view) {
        this.view = view;
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
        title.setFont(TITLEFONT);
        title.setTextAlignment(TextAlignment.CENTER);

        Text description = new Text(
                "SpeedQZ is een quiz waarbij je zo snel mogelijk de vragen moet beantwoorden. Je kan kiezen uit verschillende categorieën. Veel plezier!");
        description.setFont(FONT);
        description.setTextAlignment(TextAlignment.CENTER);
        description.setWrappingWidth(WRAPPINGWIDTH);

        leftSide.getChildren().addAll(title, description);

        Text titleRight = new Text("Kies een categorie:");
        titleRight.setFont(FONT);
        titleRight.setTextAlignment(TextAlignment.CENTER);

        Button speedButton = createButton("Snelheid", "speed");
        Button buildingsButton = createButton("Gebouwen", "buildings");
        Button paintingsButton = createButton("Schilderijen", "paintings");
        Button mixButton = createButton("Mix", "mix");

        rightSide.getChildren().addAll(titleRight, speedButton, buildingsButton, paintingsButton, mixButton);

        this.getChildren().addAll(leftSide, rightSide);
    }

    private Button createButton(final String dutchText, final String englishText) {
        Button button = new Button(dutchText);
        button.setPrefSize(BUTTONWIDTH, BUTTONHEIGHT);
        button.setOnAction(e -> view.startNewGame(englishText));
        return button;
    }
}
