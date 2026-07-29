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
     * Main method that launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}