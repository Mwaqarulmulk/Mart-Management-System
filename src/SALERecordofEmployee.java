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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class SALERecordofEmployee implements Initializable {
    public Button NEXTCustomerRButton;
    public Label RSamountR;
    public Button PreviousCustomerRButton1;
    public Button BackRecordSaleButtonS;
    public TableView<Item> tableViewPurShowR;
    public TableColumn<Item,Integer> IDColShowR;
    public TableColumn<Item,String> NameColShowR;
    public TableColumn<Item,Double> PriceColShowR;
    public TableColumn<Item,Integer> QuantityColShowR;
    public Label EmployeeShowLbR;
    public Label CustomerSHOWlbR;
    public Label TimeShowlbR;
    ArrayList<Customer> listOFCustomerRecord=new ArrayList<>();
    ArrayList<Customer> listOFCustomerRecordTemp;

    public void NextCustomerRF(ActionEvent actionEvent) {
        Main.add++;

        if (Main.add >= 0) {
            PreviousCustomerRButton1.setDisable(true);
        }
        if (Main.add >= listOFCustomerRecord.size()-1) {
            NEXTCustomerRButton.setDisable(true);
            PreviousCustomerRButton1.setDisable(false);
        }

        Stage stage = (Stage) NEXTCustomerRButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SALERecordofEmployee.fxml"));
        stage.setTitle("Administer");
        try {
            stage.setScene(new Scene(fx.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    public void PreviousRecordSaleF(ActionEvent actionEvent) throws IOException {

        Main.add--;

        if (Main.add > 0) {
            PreviousCustomerRButton1.setDisable(false);
        }
        if (Main.add >= listOFCustomerRecord.size()-1) {
            NEXTCustomerRButton.setDisable(true);
        }

        Stage stage = (Stage) PreviousCustomerRButton1.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SALERecordofEmployee.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();


    }

    public void BackRecordSaleF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackRecordSaleButtonS.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SaleEmployeeSc.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            System.out.println(EmployeeLoginSc.WorkingEmployeeDSale);
            String iName=capitalizeWords(EmployeeLoginSc.WorkingEmployeeDSale);
            listOFCustomerRecordTemp = Customer.cDisplay();
      //  System.out.println(listOFCustomerRecord.get(0).getWorkingEmployee());
            for (int i = 0; i < listOFCustomerRecordTemp.size(); i++) {
                if(listOFCustomerRecordTemp.get(i).getWorkingEmployee().equals(iName))
                {
                    System.out.println(iName);
                    listOFCustomerRecord.add(listOFCustomerRecordTemp.get(i));
                }

            }
           // System.out.println(listOFCustomerRecord.size());

            if (Main.add < 0) {
                PreviousCustomerRButton1.setDisable(false);
            }

            if (Main.add >=listOFCustomerRecord.size()-1) {
                NEXTCustomerRButton.setDisable(true);
            }




        CustomerSHOWlbR.setText(listOFCustomerRecord.get(Main.add).getCustomerName());
            EmployeeShowLbR.setText(listOFCustomerRecord.get(Main.add).getWorkingEmployee());
            TimeShowlbR.setText(String.valueOf(listOFCustomerRecord.get(Main.add).getNow()));
            RSamountR.setText(String.valueOf(listOFCustomerRecord.get(Main.add).getcCheckout()));


        IDColShowR.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        NameColShowR.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        PriceColShowR.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        QuantityColShowR.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));

        ArrayList<Item> itemArrayListPurchaseA = listOFCustomerRecord.get(Main.add).getcItem();
        ObservableList<Item> productListA = FXCollections.observableArrayList(itemArrayListPurchaseA);
        tableViewPurShowR.setItems(productListA);

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
}
