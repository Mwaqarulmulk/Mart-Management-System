//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeControl {
    public Button addemployeeButton;
    public Button seaarchEmployeeButton;
    public Button deleteEmployeeButton;
    public Button displayEmployeeButton;
    public Button UpdateEmployeeButton;
    public Button backEmployeeButton;


    public void addEmployeeF(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = (Stage) addemployeeButton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("AddEmployee.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }
        catch (Exception e)
        {
            e.getMessage();
        }


    }

    public void searchEmployeeF(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) seaarchEmployeeButton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("SearchEmployeeSc.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void deleteEmployeeF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) deleteEmployeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteEmployeeSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void displayEmployeeF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) displayEmployeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("DisplayEmployeeSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void updateEmployeeF(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) UpdateEmployeeButton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdateEmployeeSc.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void backEmployeeF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backEmployeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Administer.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}
