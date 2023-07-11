//FA22


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowPurchaseSC implements Initializable {
    public Button purchaseITButton;
    public TableColumn<Item, Integer> IDColShow;
    public TableColumn<Item, String> NameColShow;
    public TableColumn<Item, Double> PriceColShow;
    public TableColumn<Item, Integer> QuantityColShow;
    public TableView<Item> tableViewPurShow;
    public Label RSamount;
    public Label EmployeeShowLb;
    public Label CustomerSHOWlb;
    public Label TimeShowlb;
    public Button BackShowB;
    private ArrayList<Item> itemArrayListPurchase = new ArrayList<>();
    private Customer customer12 =new Customer();



    public void purchaseITF(ActionEvent actionEvent) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            customer12=PurchasedSc.rtnCustomer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RSamount.setText(String.valueOf(customer12.getcCheckout()));
        EmployeeShowLb.setText(customer12.getWorkingEmployee());
        CustomerSHOWlb.setText(customer12.getCustomerName());
        TimeShowlb.setText(String.valueOf(customer12.getNow()));
        IDColShow.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        NameColShow.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        PriceColShow.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        QuantityColShow.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));



        itemArrayListPurchase = customer12.getcItem();
        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayListPurchase);
        tableViewPurShow.setItems(productList);
    }

    public void BackShowF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackShowB.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SaleEmployeeSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}
