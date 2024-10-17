package ukf.sk.lopta;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Ball extends Canvas {

    private double dx;
    private double dy;
    private double width;
    private double height;

    private double minX, maxX, minY, maxY;
    private Random random = new Random();
    private static final double SPEED = 2.0;

    public Ball(double x, double y, double width, double height) {
        super(width, height);
        this.width = width;
        this.height = height;

        this.dx = randomDirection() * SPEED;
        this.dy = randomDirection() * SPEED;

        this.minX = x - 50;
        this.minY = y-60;
        this.maxX = x + 50;
        this.maxY = y+60;

        setLayoutX(x);
        setLayoutY(y);
        draw();
    }

    private int randomDirection() {
        return random.nextBoolean() ? 1 : -1;
    }

    private void draw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.clearRect(0, 0, width, height);
        gc.fillOval(0, 0, 15, 10);
    }

    public void move() {
        double x = getLayoutX() + dx;
        double y = getLayoutY() + dy;

        if (x <= minX || x >= maxX - getWidth()) {
            dx *= -1;
        }
        if (y <= minY || y >= maxY - getHeight()) {
            dy *= -1;
        }

        setLayoutX(x);
        setLayoutY(y);
        draw();
    }
}
