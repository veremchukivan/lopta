package ukf.sk.lopta;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

public class HelloApplication extends Application {

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        HBox bttns = new HBox();
        Button pridaj = new Button("Pridaj");
        bttns.getChildren().add(pridaj);
        root.getChildren().addAll(bttns);

        pridaj.setOnAction(evt -> {
            double randomX = random.nextInt(400);
            double randomY = random.nextInt(400);

            Ball ball = new Ball(randomX, randomY, 20, 20);
            root.getChildren().add(ball);

            Timeline ballTimeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
                ball.move();
            }));
            ballTimeline.setCycleCount(Timeline.INDEFINITE);
            ballTimeline.play();
        });

        primaryStage.setScene(new Scene(root, 520, 520));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
