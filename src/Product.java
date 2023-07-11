//FA22


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Product {
    public Button addProductButton;
    public Button seaarchProductsButton;
    public Button deleteProductsButton;
    public Button displayProductsButton;
    public Button UpdateProductsButton;
    public Button backProductsButton;


    public void addProductsF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) addProductButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("ADDPRODUCT.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void searchProductsF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) seaarchProductsButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SearchProductSc.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void deleteProductsF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) deleteProductsButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("DeleteProductSc.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void updateProductseF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) UpdateProductsButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("UpdatProductSc.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void displayProductsF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) displayProductsButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("DisplayProductSc.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    public void backProductsF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backProductsButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Administer.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}
