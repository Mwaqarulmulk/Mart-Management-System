//FA22


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DisplayEmployeeSc implements Initializable {
    public TableView<Employee> tableViewDisplayEmployee;
    public TableColumn<Employee,Integer> IDECol;
    public TableColumn<Employee,String> NameECol;
    public TableColumn<Employee,String> CityECol;
    public TableColumn<Employee,Double> SalaryECol;
    public TableColumn<Employee,String> UserNameECol;
    public TableColumn<Employee,String> PasswordECol;
    public Button BackDisplayEmployeeButton;
    ArrayList<Employee> employeeArrayList=new ArrayList<>();

    public void BackDisplayEmployeeF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackDisplayEmployeeButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("EmployeeControl.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            IDECol.setCellValueFactory(new PropertyValueFactory<>("id"));
            NameECol.setCellValueFactory(new PropertyValueFactory<>("name"));

            CityECol.setCellValueFactory(new PropertyValueFactory<>("Address"));
            SalaryECol.setCellValueFactory(new PropertyValueFactory<>("salary"));
            UserNameECol.setCellValueFactory(new PropertyValueFactory<>("userName"));
            PasswordECol.setCellValueFactory(new PropertyValueFactory<>("password"));


            // Set the ObservableList as the data source for the TableView
            tableViewDisplayEmployee.setItems(dataModelEmployee());
        }catch (Exception e)
        {
            e.getMessage();
        }
    }

    private ObservableList<Employee> dataModelEmployee() throws IOException, ClassNotFoundException {

        employeeArrayList=(ArrayList<Employee>) Employee.readEmployee();
        ObservableList<Employee> EmployeeObList = FXCollections.observableArrayList(employeeArrayList);

        return EmployeeObList;
    }
}
