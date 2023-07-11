//FA22


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SaleEmployeeSc {
    public Button SaleProductButton;
    public Button SaleCustomerButton;
    public Button SaleRecordButton;
    public Button ChangePass;
    public Button BackSAleButtoon;

    public void SaleProductF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) SaleProductButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("PurchasedSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void SaleRecordF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) SaleRecordButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SALERecordofEmployee.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void ChangePassF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ChangePass.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("ChangeEmployeePassword.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void BackSaleF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackSAleButtoon.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeLoginSC.fxml"));
        stage.setTitle("Employee");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}
