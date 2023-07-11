//FA22

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ADDPRODUCT {
    public TextField IDAddProduct;
    public TextField QuantityADDProduct;
    public TextField priceADDProduct;
    public TextField nameADDProduct;
    public Button ADD2ProductBUTTON;
    public Button BackAddProductButton;
    //public TextField priceADDProduct1;

    public void ADD2ProductF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ADD2ProductBUTTON.getScene().getWindow();

        FXMLLoader fx = new FXMLLoader(Main.class.getResource("ADDPRODUCT.fxml"));
        stage.setTitle("PRODUCT");
        stage.setScene(new Scene(fx.load()));
        stage.show();

        try {
            String idText = IDAddProduct.getText().trim();
            String nameText = nameADDProduct.getText().trim();
            String priceText = priceADDProduct.getText().trim();
            String quantityText = QuantityADDProduct.getText().trim();

            if (idText.isEmpty() || nameText.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Dialog");
                alert.setContentText("Please Fill All Fields");
                alert.showAndWait();
            } else {
                System.out.println("Enter Product Id.");
                int itemId = Integer.parseInt(idText);
                System.out.println("Enter Product Name.");
                String itemName = capitalizeWords(nameText);
                System.out.println("Enter Product Price.");
                double itemPrice = Double.parseDouble(priceText);
                System.out.println("Enter Product Quantity.");
                int itemQuantity = Integer.parseInt(quantityText);

                Item item = new Item(itemId, itemName, itemPrice, itemQuantity);
                item.setPerItemQuantity(0);
                Item.additem(item);
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void BackAddProductF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackAddProductButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Product.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
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
