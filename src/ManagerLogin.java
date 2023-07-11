//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerLogin  {

    public TextField UsernameEmployeeLoginlbM;

    public Button LOGINEMployeeBUttonM;
    public Button BACKLoginEM;
    public PasswordField EMployeeLoginPasswordLbMP;
    public Button checkButton;
    public Button LOGINEMployeeBUttonMj;
    String mName="Manager";
    String mPass="Manager@123";
    String cName;
    String cPass;

    public void LButton(ActionEvent actionEvent) throws IOException {





    }

    public void BACKLoginF(ActionEvent actionEvent) throws IOException {

    }

    public void CheckF(ActionEvent actionEvent) {
    }

    public void BACKLoginFM(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BACKLoginEM.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void LoginManagerButton(ActionEvent actionEvent) throws IOException {

        String user=UsernameEmployeeLoginlbM.getText().trim();

        String pass=EMployeeLoginPasswordLbMP.getText().trim();
        LOGINEMployeeBUttonMj.setDisable(false);
        boolean ch= (mName.equals(user) && mPass.equals(pass));
        if(ch){

            Stage stage = (Stage) LOGINEMployeeBUttonMj.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("Administer.fxml"));
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
}
