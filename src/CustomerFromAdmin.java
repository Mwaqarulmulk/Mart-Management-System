//FA22


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerFromAdmin implements Initializable {

    public Button NextCustomerButton;
    public Label RSamountAdmin;
    public TableView<Item> tableViewPurShowA;
    public TableColumn<Item,Integer> IDColShowA;
    public TableColumn<Item ,String> NameColShowA;
    public TableColumn<Item,Double> PriceColShowA;
    public TableColumn<Item ,Integer> QuantityColShowA;
    public Label EmployeeShowLbA;
    public Label CustomerSHOWlbA;
    public Label TimeShowlbA;
    public Button PreiousCustomerButton1;
    public Button BACKRecordButton;
    ArrayList<Customer> listOFCustomer;

    public void NextCustomerF(ActionEvent actionEvent) throws IOException {
        Main.add++;

        if (Main.add >= 0) {
            PreiousCustomerButton1.setDisable(true);
        }
        if (Main.add >= listOFCustomer.size() - 1) {
            NextCustomerButton.setDisable(true);
            PreiousCustomerButton1.setDisable(false);
        }

        Stage stage = (Stage) NextCustomerButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("CustomerFromAdmin.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            listOFCustomer = Customer.cDisplay();
        } catch (Exception e) {
            System.out.println("Label problem");
        }
            if(listOFCustomer==null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Record");
                alert.setContentText("Record Not Found       ( Empty Record ).....!");
                alert.showAndWait();
                Stage stage=new Stage();
                FXMLLoader fx = new FXMLLoader(Main.class.getResource("Administer.fxml"));
                stage.setTitle("Administer");
                try {
                    stage.setScene(new Scene(fx.load()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.show();

            }
            else {

                if (Main.add < 0) {
                    PreiousCustomerButton1.setDisable(false);
                }
                if (Main.add >= listOFCustomer.size() - 1) {
                    NextCustomerButton.setDisable(true);
                }

                CustomerSHOWlbA.setText(listOFCustomer.get(Main.add).getCustomerName());
                EmployeeShowLbA.setText(listOFCustomer.get(Main.add).getWorkingEmployee());
                TimeShowlbA.setText(String.valueOf(listOFCustomer.get(Main.add).getNow()));
                RSamountAdmin.setText(String.valueOf(listOFCustomer.get(Main.add).getcCheckout()));


                IDColShowA.setCellValueFactory(new PropertyValueFactory<>("itemId"));
                NameColShowA.setCellValueFactory(new PropertyValueFactory<>("itemName"));
                PriceColShowA.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
                QuantityColShowA.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));

                ArrayList<Item> itemArrayListPurchaseA = listOFCustomer.get(Main.add).getcItem();
                ObservableList<Item> productListA = FXCollections.observableArrayList(itemArrayListPurchaseA);
                tableViewPurShowA.setItems(productListA);
            }
    }

    public void PreCustomerF(ActionEvent actionEvent) throws IOException {
        Main.add--;

        if (Main.add > 0) {
            PreiousCustomerButton1.setDisable(false);
        }
        if (Main.add >= listOFCustomer.size() - 1) {
            NextCustomerButton.setDisable(true);
        }

        Stage stage = (Stage) PreiousCustomerButton1.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("CustomerFromAdmin.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void BackRecordF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BACKRecordButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Administer.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }


}
