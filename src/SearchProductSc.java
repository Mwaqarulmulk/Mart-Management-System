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

public class SearchProductSc implements Initializable {
    public Button searchSearchPButton;
    public TextField searchSearchID;
    public Button BackSearchProductButton;
    public TableView<Item> UpdateTableSearch;
    public TableColumn<Item,Integer> TidCl;
    public TableColumn<Item,String> TnameCl;
    public TableColumn<Item,Double> TpriceCl;
    public TableColumn<Item,Integer> TquantityCl;
    ObservableList<Item> productListU;
    private String itemNameo=null;

    public void searchSearchPButton(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        itemNameo=capitalizeWords(searchSearchID.getText().trim());
        Item itmu= Item.searchItem(itemNameo);

        if(itmu.getItemName()==null)
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning Alert Name");
            alert.setContentText("Please Write Correct Name.....!");
            alert.showAndWait();

        }
        else {
            int Uid = itmu.getItemId();
            String Uname = itmu.getItemName();
            double Uprice = itmu.getItemPrice();
            int Uquantity = itmu.getItemQuantity();
            System.out.println("pak2");
            productListU = FXCollections.observableArrayList(new Item(Uid, Uname, Uprice, Uquantity));
            UpdateTableSearch.setItems(productListU);
        }

    }

    public void BackSearchProductF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackSearchProductButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Product.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            TidCl.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            TnameCl.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            TpriceCl.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            TquantityCl.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
            // Set the ObservableList as the data source for the TableView
            UpdateTableSearch.setItems(productListU);
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
