package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Simple PhilippineFlagApp class creates a drawing of the Philippine flag
 * on a JavaFX Canvas.
 *
 * The flag consists of a white triangle on the left with a sun and
 * three stars, and blue and red horizontal stripes.
 */
public class PhilippineFlagApp extends Application {
    // Canvas where the flag will be drawn
    private final Canvas canvas;

    // Graphics context used for drawing shapes and colors
    private GraphicsContext graphics;

    /**
     * Constructor creates a new canvas with specified dimensions.
     */
    public PhilippineFlagApp() {
        // PH flag 2:1 ratio standard
        int canvasWidth = 600;
        int canvasHeight = 300;

        // Create the canvas where we'll draw the flag
        this.canvas = new Canvas(canvasWidth, canvasHeight);
    }

    /**
     * Creates and draws the complete Philippine flag on the canvas.
     */
    public Canvas drawFlag(int width, int height, int x, int y) {
        // Get the graphics context to start drawing
        graphics = canvas.getGraphicsContext2D();

        // Draw the main components of the flag
        drawBlueStripe(x, y, width, height);
        drawRedStripe(x, y, width, height);
        drawWhiteTriangle(x, y, width, height);
        drawSun(x, y, width, height);
        drawThreeStars(x, y, width, height);

        // Return the canvas with the completed flag
        return canvas;
    }

    /**
     * Draws the blue horizontal stripe
     * on the top half of the flag.
     */
    private void drawBlueStripe(int x, int y, int width, int height) {
        // Set the fill color to blue
        graphics.setFill(Color.BLUE);

        // Draw the blue stripe
        graphics.fillRect(x, y, width, height / 2);
    }

    /**
     * Draws the red horizontal stripe
     * on the bottom half of the flag.
     */
    private void drawRedStripe(int x, int y, int width, int height) {
        // Set the fill color to red
        graphics.setFill(Color.RED);

        // Draw the red stripe
        graphics.fillRect(x, y + height / 2, width, height / 2);
    }

    /**
     * Draws the white triangle on the
     * left side of the flag.
     */
    private void drawWhiteTriangle(int x, int y, int width, int height) {
        // Set the fill color to white
        graphics.setFill(Color.WHITE);

        // Define the X coordinates of the triangle
        double[] triangleX = {x, x, x + width * 0.45};

        // Define the Y coordinates of the triangle
        double[] triangleY = {y, y + height, y + height / 2};

        // Draw the white triangle
        graphics.fillPolygon(triangleX, triangleY, 3);
    }

    /**
     * Draws the sun symbol in the white triangle.
     *
     * The sun consists of a circle and
     * eight rays extending from it.
     */
    private void drawSun(int x, int y, int width, int height) {
        // Calculate sun position
        double sunCenterX = x + width * 0.15;
        double sunCenterY = y + height / 2;

        // Calculate sun size
        double sunRadius = height * 0.083;

        // Set sun color
        graphics.setFill(Color.GOLD);

        // Draw the main sun circle
        graphics.fillOval(sunCenterX - sunRadius, sunCenterY - sunRadius, sunRadius * 2, sunRadius * 2);

        // Set ray color
        graphics.setStroke(Color.GOLD);

        // Set ray thickness
        graphics.setLineWidth(8);

        // Draw the 8 rays
        for (int i = 0; i < 8; i++) {
            // Calculate the angle of the ray
            double angle = Math.toRadians(i * 45);

            // Distance from the center
            // where the ray starts
            double innerRadius = sunRadius + 5;

            // Distance from the center
            // where the ray ends
            double outerRadius = sunRadius + 25;

            // Calculate starting X coordinate
            double x1 = sunCenterX + Math.cos(angle) * innerRadius;

            // Calculate starting Y coordinate
            double y1 = sunCenterY + Math.sin(angle) * innerRadius;

            // Calculate ending X coordinate
            double x2 = sunCenterX + Math.cos(angle) * outerRadius;

            // Calculate ending Y coordinate
            double y2 = sunCenterY + Math.sin(angle) * outerRadius;

            // Draw the ray
            graphics.strokeLine(x1, y1, x2, y2);
        }
    }

    /**
     * Draws all three stars on the flag.
     *
     * Two stars are positioned on the left
     * corners of the triangle, and one star
     * is positioned on the right side.
     */
    private void drawThreeStars(
            int x,
            int y,
            int width,
            int height) {

        // Calculate star size based on flag height
        double starSize =
                height * 0.05;

        // Draw top-left star
        drawSingleStar(
                starSize,
                x + width * 0.04,
                y + height * 0.15
        );

        // Draw bottom-left star
        drawSingleStar(
                starSize,
                x + width * 0.04,
                y + height * 0.85
        );

        // Draw center star
        drawSingleStar(
                starSize,
                x + width * 0.35,
                y + height * 0.50
        );
    }

    /**
     * Draws a single 5-pointed star
     * at the specified position.
     */
    private void drawSingleStar(
            double size,
            double x,
            double y) {

        // Number of outer points
        int points = 5;

        // Calculate the radius of the inner points
        double innerRadius =
                size * 0.4;

        // Arrays to store star coordinates
        double[] xPoints =
                new double[10];

        double[] yPoints =
                new double[10];

        // Calculate all 10 points of the star
        for (int i = 0; i < 10; i++) {

            // Calculate the angle
            double angle =
                    Math.toRadians(
                            -90 + i * 36
                    );

            // Alternate between outer
            // and inner points
            double currentRadius;

            if (i % 2 == 0) {
                currentRadius = size;
            } else {
                currentRadius = innerRadius;
            }

            // Calculate X coordinate
            xPoints[i] =
                    x
                            + Math.cos(angle)
                            * currentRadius;

            // Calculate Y coordinate
            yPoints[i] =
                    y
                            + Math.sin(angle)
                            * currentRadius;
        }

        // Set star color
        graphics.setFill(Color.GOLD);

        // Draw the star
        graphics.fillPolygon(
                xPoints,
                yPoints,
                10
        );
    }

    /**
     * Starts the JavaFX application.
     */
    @Override
    public void start(Stage stage) {

        // PH flag 2:1 ratio standard
        int width = 600;
        int height = 300;

        // Draw the Philippine flag
        Canvas flagCanvas =
                drawFlag(
                        width,
                        height,
                        0,
                        0
                );

        // Place the canvas inside a Pane
        Pane root =
                new Pane(flagCanvas);

        // Create the scene
        Scene scene =
                new Scene(
                        root,
                        width,
                        height
                );

        // Set the window title
        stage.setTitle(
                "Philippine Flag"
        );

        // Set the scene
        stage.setScene(scene);

        // Display the window
        stage.show();
    }

    /**
     * Main method that launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}