//FA22



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

public class DeleteEmployeeSc implements Initializable {
    public TableView<Employee> tableViewDisplayEmployee;
    public TableColumn<Employee,Integer> IDEColD;
    public TableColumn<Employee,String> NameEColD;
    public TableColumn<Employee,String> CityEColD;
    public TableColumn<Employee,String> SalaryEColD;
    public TableColumn<Employee,String> UserNameEColD;
    public TableColumn<Employee,String> PasswordEColD;
    public Button BackdeleteButtonD;
    public Button DeleteEMployeeButton;
    public TextField searchDeletelabel;
    public Button searchDeleteEmployeeButton;
    ObservableList<Employee> EmployeeListUD;
    String deleteName=null;

    public void BackkDEleteEmployeeD(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackdeleteButtonD.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeControl.fxml"));
        stage.setTitle("Admin Access");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void DeleteEmployeeF(ActionEvent actionEvent) throws IOException {


        Employee.deleteEmployee(deleteName);

        Stage stage = (Stage) DeleteEMployeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteEmployeeSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            IDEColD.setCellValueFactory(new PropertyValueFactory<>("id"));
            NameEColD.setCellValueFactory(new PropertyValueFactory<>("name"));
            SalaryEColD.setCellValueFactory(new PropertyValueFactory<>("salary"));
            CityEColD.setCellValueFactory(new PropertyValueFactory<>("Address"));
            UserNameEColD.setCellValueFactory(new PropertyValueFactory<>("userName"));
            PasswordEColD.setCellValueFactory(new PropertyValueFactory<>("password"));
            // Set the ObservableList as the data source for the TableView
            tableViewDisplayEmployee.setItems(EmployeeListUD);
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

    public void SearchEMployeeF(ActionEvent actionEvent) {
        try {
            DeleteEMployeeButton.setDisable(true);
            deleteName=capitalizeWords(searchDeletelabel.getText().trim());
            Employee employee=Employee.searchEmployee(deleteName);
            if (employee.getName()==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Name");
                alert.setContentText("Please Type Correct Name in Field.....!");
                alert.showAndWait();
            }
            else{
                DeleteEMployeeButton.setDisable(false);
                EmployeeListUD = FXCollections.observableArrayList(new Employee(employee.getId(), employee.getName(), employee.getSalary(), employee.getAddress(), employee.getUserName(), employee.getPassword()));
                tableViewDisplayEmployee.setItems(EmployeeListUD);
            }
        }catch (Exception e)
        {
            e.getMessage();
        }

    }
}
