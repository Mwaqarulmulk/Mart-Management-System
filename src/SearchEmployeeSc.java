//FA22-BSE-153


import javafx.collections.FXCollections;
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

public class SearchEmployeeSc implements Initializable {
    public TableView<Employee> tableViewDSearchEmployee;
    public TableColumn<Employee,Integer> IDEColDS;
    public TableColumn<Employee,String> NameEColDS;
    public TableColumn<Employee,String> CityEColDS;
    public TableColumn<Employee,Double> SalaryEColDS;
    public TableColumn<Employee,String> UserNameEColDS;
    public TableColumn<Employee,String> PasswordEColDS;
    public Button SearchSearchDeleteButton;
    public Button BackSearchEmployeeButtonE;
    public TextField SearchSearchEmployeelb;
    String SearchNameS;
    ObservableList<Employee> EmployeeListUDS;

    public void SearchSearchEmployeeF(ActionEvent actionEvent) {
        try {
            SearchNameS=capitalizeWords(SearchSearchEmployeelb.getText().trim());
            Employee employee=Employee.searchEmployee(SearchNameS);
            if (employee.getName()==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Name");
                alert.setContentText("Please Type Correct Name in Field.....!");
                alert.showAndWait();
            }
            else{

                EmployeeListUDS = FXCollections.observableArrayList(new Employee(employee.getId(), employee.getName(), employee.getSalary(), employee.getAddress(), employee.getUserName(), employee.getPassword()));
                tableViewDSearchEmployee.setItems(EmployeeListUDS);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }

    }

    public void BackSearchEmployeeF(ActionEvent actionEvent)  {
        try {
            Stage stage = (Stage) BackSearchEmployeeButtonE.getScene().getWindow();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            IDEColDS.setCellValueFactory(new PropertyValueFactory<>("id"));
            NameEColDS.setCellValueFactory(new PropertyValueFactory<>("name"));
            SalaryEColDS.setCellValueFactory(new PropertyValueFactory<>("salary"));
            CityEColDS.setCellValueFactory(new PropertyValueFactory<>("Address"));
            UserNameEColDS.setCellValueFactory(new PropertyValueFactory<>("userName"));
            PasswordEColDS.setCellValueFactory(new PropertyValueFactory<>("password"));
            // Set the ObservableList as the data source for the TableView
            tableViewDSearchEmployee.setItems(EmployeeListUDS);
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
}
