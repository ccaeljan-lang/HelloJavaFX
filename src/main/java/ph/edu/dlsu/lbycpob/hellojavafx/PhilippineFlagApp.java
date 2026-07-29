package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PhilippineFlagApp extends Application {
    @Override
    public void start(Stage stage) {
        // PH flag 2:1 ratio standard
        double width = 600;
        double height = 300;

        // Creates the canvas
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Blue upper
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, width, height / 2);

        // Red bottom
        gc.setFill(Color.RED);
        gc.fillRect(0, height / 2, width, height / 2);

        // White Triangle
        gc.setFill(Color.WHITE);
        double[] triangleX = {0, 0, width * 0.45};
        double[] triangleY = {0, height, height / 2};
        gc.fillPolygon(triangleX, triangleY, 3);

        // Sun location
        double sunX = width * 0.15;
        double sunY = height / 2;
        double sunRadius = 25;

        // Sun rays
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(8);

        // Revolve sun rays
        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(i * 45);
            double innerRadius = 30;
            double outerRadius = 50;
            double x1 = sunX + Math.cos(angle) * innerRadius;
            double y1 = sunY + Math.sin(angle) * innerRadius;
            double x2 = sunX + Math.cos(angle) * outerRadius;
            double y2 = sunY + Math.sin(angle) * outerRadius;
            gc.strokeLine(x1, y1, x2, y2);
        }

        // Sun circle
        gc.setFill(Color.YELLOW);
        gc.fillOval(sunX - sunRadius, sunY - sunRadius, sunRadius * 2, sunRadius * 2);
    }
}