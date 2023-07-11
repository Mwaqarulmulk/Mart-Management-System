//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class AddEmployee {

    public TextField CityADDEmployee;
    public Button RandomButton;
    public Button BackAddEmployeeButton;
    public Button ADDEmployeeOBUTTON;
    public TextField nameADDEmployee;
    public TextField priceADDEmployee;
    public TextField UserNameAddEmployee;
    public TextField IDAddEmployee;

    static String passworde=null;
    public Label passEmployee;


    public void ADDEmployeeOF(ActionEvent actionEvent) throws IOException {
        ADDEmployeeOBUTTON.setDisable(true);
        try
        {
            Stage stage = (Stage) ADDEmployeeOBUTTON.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("AddEmployee.fxml"));
            stage.setTitle("main");
            stage.setScene(new Scene(fx.load()));
            stage.show();
            int id = Integer.parseInt(IDAddEmployee.getText().trim());
            String name = capitalizeWords(nameADDEmployee.getText().trim());
            double salary=Double.parseDouble(priceADDEmployee.getText().trim());
            String city = capitalizeWords(CityADDEmployee.getText().trim());
            String usern = UserNameAddEmployee.getText().trim();

            if ( String.valueOf(id).isEmpty() || name.isEmpty() || city.isEmpty() || usern.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Dialog");
                alert.setContentText("Please Fill All Fields");
                alert.showAndWait();
            } else {

                Employee.addEmployee(new Employee(id, name,salary,city, usern, passworde));
            }
        }catch (Exception e)
        {
            e.getMessage();
        }



    }

    public void BackAddEmployeeF(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) BackAddEmployeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeControl.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void RandoomPassword(ActionEvent actionEvent) {

        passworde=generateRandomWord();
        passEmployee.setText(passworde);
        passEmployee.setStyle("-fx-background-color: #ff0000;");
        ADDEmployeeOBUTTON.setDisable(false);

    }

    public String capitalizeWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1).toLowerCase();
                result.append(firstChar).append(restOfWord).append(" ");
            }
        }

        return result.toString().trim();
    }


        public  String generateRandomWord() {
            String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String digits = "0123456789";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                int index = random.nextInt(alphabets.length());
                char randomChar = alphabets.charAt(index);
                sb.append(randomChar);
            }

            sb.append("@");

            for (int i = 0; i < 4; i++) {
                int index = random.nextInt(digits.length());
                char randomChar = digits.charAt(index);
                sb.append(randomChar);
            }

            return sb.toString();
        }

}
