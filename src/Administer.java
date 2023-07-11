//FA22


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Administer {


    public Button employeeAd;
    public Button ProductButton;
    public Button customerButton;
    public Button recordButton;
    public Button backButton;

    public void EmployeeAdF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) employeeAd.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeControl.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void productF(ActionEvent actionEvent) {
        Stage stage = (Stage) ProductButton.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("Product.fxml"));
            stage.setTitle("Administer");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void customerF(ActionEvent actionEvent) {


    }

    public void recordF(ActionEvent actionEvent) {

        Stage stage = (Stage) recordButton.getScene().getWindow();
        try {
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("CustomerFromAdmin.fxml"));
            stage.setTitle("Administer");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        } catch (IOException a){
            System.out.println(a.getMessage());
        }
    }

    public void backf(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}
