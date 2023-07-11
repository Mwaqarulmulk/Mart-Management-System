//FA22-BSE-153



import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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

public class DisplayProducSc implements Initializable{
    public Button BackDisplayProductButton;

    public TableColumn<Item,Integer> IDCol;
    public TableColumn<Item,String> NameCol;
    public TableColumn<Item,Double> PriceCol;
    public TableColumn<Item,Integer> QuantityCol;
    public TableView<Item> tableViewDsplay;
    ArrayList<Item> itemArrayList=new ArrayList<>();


    public void BackDisplayProductF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackDisplayProductButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("Product.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            IDCol.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            NameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            PriceCol.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            QuantityCol.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));

           // System.out.println("pak");
            // Set the ObservableList as the data source for the TableView
            tableViewDsplay.setItems(dataModel());
        }catch (Exception e)
        {
            e.getMessage();
        }

    }


    private ObservableList<Item> dataModel() throws IOException, ClassNotFoundException {

        itemArrayList=(ArrayList<Item>) Item.display();
        ObservableList<Item> productList = FXCollections.observableArrayList(itemArrayList);

        return productList;
    }



}
