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

public class DeleteProductSc implements Initializable {
    public Button searchdeleteButton;
    public Button deleteProductls;
    public Button backdeleteButton;
    public TableView<Item> UpdateTableDelete;
    public TableColumn<Item,Integer> TidC;
    public TableColumn<Item,String> TnameC;
    public TableColumn<Item,Double> Tpricec;
    public TableColumn<Item,Integer> TquantityC;
    public TextField DeleteSearchField;
    ObservableList<Item> productListU;
    private String itemNameo=null;

    public void searchDeleteF(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        itemNameo=capitalizeWords(DeleteSearchField.getText().trim());
        Item itmu= Item.searchItem(itemNameo);

            if(itmu.getItemName()==null)
            {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Name");
                alert.setContentText("Please Type Correct Name in Field.....!");
                alert.showAndWait();

            }
            else {

                int Uid = itmu.getItemId();
                String Uname = itmu.getItemName();
                double Uprice = itmu.getItemPrice();
                int Uquantity = itmu.getItemQuantity();
                System.out.println("pak2");
                productListU = FXCollections.observableArrayList(new Item(Uid, Uname, Uprice, Uquantity));
                UpdateTableDelete.setItems(productListU);
            }

    }

    public void backDeleteF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backdeleteButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Product.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void deleteProductlF(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        Item.deleteItem(itemNameo);
        Stage stage = (Stage) deleteProductls.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteProductSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();

        System.out.println(itemNameo);




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TidC.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            TnameC.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            Tpricec.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            TquantityC.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
            // Set the ObservableList as the data source for the TableView
            UpdateTableDelete.setItems(productListU);
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
