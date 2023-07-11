//FA22


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen {

    public Button Close;
    public Button administerButton;
    public Button employeeButton;

    public void Exit(ActionEvent actionEvent) {
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }

    public void administerF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) administerButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("ManagerLogin.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void employeeF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) employeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeLoginSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();

    }
}
