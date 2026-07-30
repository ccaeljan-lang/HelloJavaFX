package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MinimalistHelloApp extends Application {
    @Override
    public void start(Stage window){
        Label label = new Label("   \t\t   Hello LBYCPOB OOP! by Group 7 - Cristobal, Paingan, Villaluz   \t\t   ");
        window.setTitle("HelloApplication by Group 7 - Cristobal, Paingan, Villaluz");
        window.setScene(new Scene(label, 470, 240));
        window.show();
    }
    static void main() {
        launch();
    }
}
