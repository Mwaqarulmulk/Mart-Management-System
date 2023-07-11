//FA22
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static String nameCustomerp;
    static String cityCustomerp;
    static int idCustomerP;
    public static int add=0;


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}