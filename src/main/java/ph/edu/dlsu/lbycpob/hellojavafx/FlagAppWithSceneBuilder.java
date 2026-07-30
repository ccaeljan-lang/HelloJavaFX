package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class FlagAppWithSceneBuilder extends Application {
    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("flag.fxml"));

        Parent root = loader.load();

        // Create the scene
        Scene scene = new Scene(root, 1200, 638);

        // Set up the window
        stage.setTitle("My JavaFX Image");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
