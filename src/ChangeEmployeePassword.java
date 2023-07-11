//FA22-BSE-153


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeEmployeePassword {


    public TextField UsernameChange;
    public Button UpdatePasswordButton;
    public Button BackPasswordButton;
    public PasswordField passwordChange;
    public PasswordField passwordConfirm;

    public void UpdatePassWordButton(ActionEvent actionEvent) throws IOException {

        String changename=UsernameChange.getText().trim();
        String changePasswd=passwordChange.getText().trim();
        String confirmpass=passwordConfirm.getText().trim();

        if(changePasswd.equals(confirmpass))
        {

            Employee em=new Employee(0,EmployeeLoginSc.WorkingEmployeeDSale,0,null,null,null);

            Employee employee124=Employee.searchEmployee(EmployeeLoginSc.WorkingEmployeeDSale);
            employee124.setUserName(changename);
            employee124.setPassword(confirmpass);
            Employee.updateEmployee(em,employee124);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning Alert Password");
            alert.setContentText("Successfully Changed.....!");
            alert.showAndWait();
            Stage stage = (Stage) UpdatePasswordButton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("SaleEmployeeSc.fxml"));
            stage.setTitle("Admin ");
            stage.setScene(new Scene(fx.load()));
            stage.show();


        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning Alert Password");
            alert.setContentText("Please Type Correct USERNAME OR PASSWORD.....!");
            alert.showAndWait();
        }

    }

    public void BackPasswordButton(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) BackPasswordButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SaleEmployeeSc.fxml"));
        stage.setTitle("Admin ");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}
