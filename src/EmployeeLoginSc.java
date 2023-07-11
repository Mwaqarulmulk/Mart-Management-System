//FA22


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeLoginSc {
    public TextField UsernameEmployeeLoginlb;
    public PasswordField EMployeeLoginPasswordLb;
    public Button LOGINEMployeeBUtton;
    public Button BACKLoginE;
    public static String WorkingEmployeeDSale;

    public void LoginEmployeeButton(ActionEvent actionEvent) throws IOException {


        String user=UsernameEmployeeLoginlb.getText().trim();

        String pass=EMployeeLoginPasswordLb.getText().trim();
        boolean tu=Employee.LoginCheck(user,pass);
        if(tu){

            Stage stage = (Stage) LOGINEMployeeBUtton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("SaleEmployeeSc.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            System.out.println("correct");
            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Please Type Correct Username or Password");
            alert.showAndWait();
        }


    }

    public void BACKLoginF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) LOGINEMployeeBUtton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }


}
