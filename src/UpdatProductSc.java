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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdatProductSc implements Initializable{
    public TextField IDnUpdateSearch;
    public TextField updateProductquantity;
    public TextField updateProductPrice;
    public TextField updateProductName;
    public Button UpdateProductButton;
    public Button BackUpdatePButtons;
    public TextField updateProductId;
    public Button UpdateSearchButton;
    public TableView<Item> UpdateTable;
    public TableColumn<Item,Integer> Tid;
    public TableColumn<Item,String>  Tname;
    public TableColumn<Item,Double>  Tprice;
    public TableColumn<Item,Integer> Tquantity;
    ArrayList<Item> itemArrayListU=new ArrayList<>();
    ObservableList<Item> productListU;
    String itemNameo=null;


    
    public void UpdateProductF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) UpdateProductButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdatProductSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
        Item tempItem=new Item(0,itemNameo,0,0);
        try {


            int idConstructor = Integer.parseInt(updateProductId.getText().trim());
            String nameConstructor = capitalizeWords(updateProductName.getText().trim());
            double priceConstructor = Double.parseDouble(updateProductPrice.getText().trim());
            int quantityConstructor = Integer.parseInt(updateProductquantity.getText().trim());
            Item itmtf = new Item(idConstructor, nameConstructor, priceConstructor, quantityConstructor);
            Item.updateItem(tempItem, itmtf);
        }catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void BackUpdatePf(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackUpdatePButtons.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Product.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void updatePSearchF(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        updateProductId.setDisable(true);
        updateProductName.setDisable(true);
        updateProductquantity.setDisable(true);
        updateProductPrice.setDisable(true);
        UpdateProductButton.setDisable(false);
        itemNameo=capitalizeWords(IDnUpdateSearch.getText().trim());
        Item itmu= Item.searchItem(itemNameo);
        if(itmu.getItemName()==null)
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Please Type Correct Name...!");
            alert.showAndWait();

        }
        else {
            updateProductId.setDisable(false);
            updateProductName.setDisable(false);
            updateProductquantity.setDisable(false);
            updateProductPrice.setDisable(false);
            UpdateProductButton.setDisable(false);

            int Uid = itmu.getItemId();
            String Uname = itmu.getItemName();
            double Uprice = itmu.getItemPrice();
            int Uquantity = itmu.getItemQuantity();
            System.out.println("pak2");
            productListU = FXCollections.observableArrayList(new Item(Uid, Uname, Uprice, Uquantity));
            UpdateTable.setItems(productListU);
        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Tid.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            Tname.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            Tprice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            Tquantity.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
            // Set the ObservableList as the data source for the TableView
            UpdateTable.setItems(productListU);
        }catch (Exception e)
        {
            e.getMessage();
        }
    }
    public  String capitalizeWords(String sentence) {
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

   /* private ObservableList<Item> dataModelU() throws IOException, ClassNotFoundException {

        itemArrayListU=(ArrayList<Item>) Item.display();
        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayListU);

        return productList;
    }*/
}



