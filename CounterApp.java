import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CounterApp extends Application {

    private int count = 0;

    @Override
    public void start(Stage primaryStage) {
        Label counterLabel = new Label("Count: 0");

        Button increaseButton = new Button("Increase");
        increaseButton.setOnAction(e -> {
            count++;
            counterLabel.setText("Count: " + count);
        });

        Button decreaseButton = new Button("Decrease");
        decreaseButton.setOnAction(e -> {
            count--;
            counterLabel.setText("Count: " + count);
        });

        HBox buttonBox = new HBox(10, increaseButton, decreaseButton);
        VBox layout = new VBox(10, counterLabel, buttonBox);

        layout.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-font-size: 14px;");

        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Counter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
