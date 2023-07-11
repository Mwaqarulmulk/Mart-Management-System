//FA22


import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateEmployeeSc implements Initializable {
    public TableView<Employee> tableViewDSearchEmployeeu;
    public TableColumn<Employee,Integer> IDEColDSU;
    public TableColumn<Employee,String> NameEColDSu;
    public TableColumn<Employee,String> CityEColDSu;
    public TableColumn<Employee,Double> SalaryEColDSu;
    public TableColumn<Employee,String> UserNameEColDSu;
    public TableColumn<Employee,String> PasswordEColDSu;
    public Button SearchSearchDeleteButtonu;
    public Button BackSearchEmployeeButtonEu;
    public TextField SearchSearchEmployeelbu;
    public TextField idU;
    public TextField salaryuE;
    public TextField usernameuE;
    public TextField passworduE;
    public TextField cityue;
    public TextField nameu;
    public Button UpdateEmployeeOButton;
    String SearchEmNameu;
    ObservableList<Employee> EmployeeolListUD;

    public void SearchSearchEmployeeFu(ActionEvent actionEvent) {

        try {
            UpdateEmployeeOButton.setDisable(true);
            SearchEmNameu=capitalizeWords(SearchSearchEmployeelbu.getText().trim());
            Employee employee=Employee.searchEmployee(SearchEmNameu);
            if (employee.getName()==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Name");
                alert.setContentText("Please Type Correct Name in Field.....!");
                alert.showAndWait();
            }
            else{
                idU.setDisable(false);
                nameu.setDisable(false);
                salaryuE.setDisable(false);
                cityue.setDisable(false);
                usernameuE.setDisable(false);
                passworduE.setDisable(false);
                UpdateEmployeeOButton.setDisable(false);
                EmployeeolListUD = FXCollections.observableArrayList(new Employee(employee.getId(), employee.getName(), employee.getSalary(), employee.getAddress(), employee.getUserName(), employee.getPassword()));
                tableViewDSearchEmployeeu.setItems(EmployeeolListUD);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }

    }

    public void BackSearchEmployeeFu(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) BackSearchEmployeeButtonEu.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeControl.fxml"));
            stage.setTitle("Admin ");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }
        catch (Exception e)
        {
            e.getMessage();
        }

    }

    public void updateEmployeeOF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) UpdateEmployeeOButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdateEmployeeSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();

        Employee em=new Employee(0,SearchEmNameu,0,null,null,null);

        int eid=Integer.parseInt(idU.getText().trim()) ;
        String namee=capitalizeWords(nameu.getText().trim());
        double salarye=Double.parseDouble(salaryuE.getText().trim());
        String citye=capitalizeWords(cityue.getText().trim());
        String usere=usernameuE.getText().trim();
        String passe=passworduE.getText().trim();
        Employee.updateEmployee(em,new Employee(eid,namee,salarye,citye,usere,passe));



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            IDEColDSU.setCellValueFactory(new PropertyValueFactory<>("id"));
            NameEColDSu.setCellValueFactory(new PropertyValueFactory<>("name"));
            SalaryEColDSu.setCellValueFactory(new PropertyValueFactory<>("salary"));
            CityEColDSu.setCellValueFactory(new PropertyValueFactory<>("Address"));
            UserNameEColDSu.setCellValueFactory(new PropertyValueFactory<>("userName"));
            PasswordEColDSu.setCellValueFactory(new PropertyValueFactory<>("password"));
            // Set the ObservableList as the data source for the TableView
            tableViewDSearchEmployeeu.setItems(EmployeeolListUD);
        }catch (Exception e)
        {
            e.getMessage();
        }

    }

    private   String capitalizeWords(String sentence) {
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
}
