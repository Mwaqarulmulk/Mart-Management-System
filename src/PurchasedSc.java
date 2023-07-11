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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PurchasedSc implements Initializable
{
    public Button BackPERButton;
    public TableView<Item> PurchaseTableSearchP;
    public TableColumn<Item,Integer> TidClP;
    public TableColumn<Item,String> TnameClP;
    public TableColumn<Item,Double> TpriceClP;
    public TableColumn<Item,Integer> TquantityClP;
    public TableColumn<Item,Integer> TPurchaseQuantityClP1;
    public Button NextPurchaseButton = new Button();
    public AnchorPane customeraddbuttonPurchase;
    public Button CustomerinPURCHASEButton;
    public Button DoneButton;
    public Button BackACustomerButton;
    String workerName;
    public Button PurchaseButton;
    public TextField NamePurchaselb;
    public Spinner<Integer> SpinnerButton;
    public Label wokingEmployeelb;
    public Button GoSearchButton;
    public Button purchasedButtonO;
    int currentValue;
    Customer c1=new Customer();
    public TextField NameCustomerPBlb;
    public TextField CityCustomerPLB;
    public TextField IDCustomerPurchasetext;
    public Button ADDPurchaseButtonB;
    ObservableList<Item> productListUP;
    double totalBll;
    static File file=new File("Customerfile2.dat");
    public static ObjectOutputStream oopS;


    static {
        try {
            oopS = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ObjectInputStream oisp;

    static {
        try {
            oisp = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  ArrayList<Item> plist;
    Item pItemitem;
    SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);


    String nameCustomerp;
    String cityCustomerp;
    int idCustomerP;

    String NamePurchaseSearch;
    int noItem;

    public void BackPERF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackPERButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("PurchasedSc.fxml"));
        stage.setTitle("main");
        stage.setScene(new Scene(fx.load()));
        stage.show();


    }

    public void NextPurchaseF(ActionEvent actionEvent) throws IOException {

        nameCustomerp = capitalizeWords(NameCustomerPBlb.getText().trim());
        cityCustomerp = capitalizeWords(CityCustomerPLB.getText().trim());
        idCustomerP =Integer.parseInt(IDCustomerPurchasetext.getText());

        Main.nameCustomerp=nameCustomerp;
        Main.cityCustomerp=cityCustomerp;
        Main.idCustomerP=idCustomerP;



        if(NameCustomerPBlb.getText().isEmpty() || CityCustomerPLB.getText().isEmpty() )
        {
            NextPurchaseButton.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning Alert Name");
            alert.setContentText("Please Fill All Field.....!");
            alert.showAndWait();
        }

else
        {
            NextPurchaseButton.setDisable(false);
            Stage stage = (Stage) NextPurchaseButton.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("NextSc.fxml"));
            stage.setTitle("PURCHASING");
            stage.setScene(new Scene(fx.load()));
            stage.show();
        }




    }


    public void SpinnerButtonF(MouseEvent mouseEvent) {


    }

    public void GoSearchF(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        NamePurchaseSearch= capitalizeWords(NamePurchaselb.getText().trim());

        pItemitem=Item.searchItem(NamePurchaseSearch);



            if (pItemitem.getItemName() == null)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning Alert Name");
                alert.setContentText("Please Type correct Name.....!");
                alert.showAndWait();
            }
            else
            {
                pItemitem=Item.searchItem(NamePurchaseSearch);
                productListUP = FXCollections.observableArrayList(new Item(pItemitem.getItemId(), pItemitem.getItemName(),pItemitem.getItemPrice(), pItemitem.getItemQuantity()));
                PurchaseTableSearchP.setItems(productListUP);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NextPurchaseButton.setDisable(false);

        try {
            wokingEmployeelb.setText(EmployeeLoginSc.WorkingEmployeeDSale);
            SpinnerButton.setValueFactory(valueFactory);
            workerName=EmployeeLoginSc.WorkingEmployeeDSale;
            TidClP.setCellValueFactory(new PropertyValueFactory<>("itemId"));
            TnameClP.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            TpriceClP.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
            TPurchaseQuantityClP1.setCellValueFactory(new PropertyValueFactory<>("itemQuantity"));
            // Set the ObservableList as the data source for the TableView
            PurchaseTableSearchP.setItems(productListUP);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void AddpurchaseF(ActionEvent actionEvent) {
        DoneButton.setDisable(false);

   //   try {
   //       currentValue=SpinnerButton.getValue();
   //       System.out.println("current values + " +currentValue);
   //       //pItemitem.setItemQuantity(currentValue);
   //       //System.out.println(currentValue);
   //       //plist.add(pItemitem);
   //   }
   //   catch (Exception e)
   //   {
   //       e.getMessage();
   //   }
   //   try {


   //       //System.out.println(currentValue);
   //       System.out.println(pItemitem);
   //       Item itm=Customer.purchased(NamePurchaseSearch,currentValue,pItemitem);
   //       plist.add(itm);
   //   } catch (IOException e) {
   //       e.getMessage();
   //   } catch (ClassNotFoundException e) {
   //       e.getMessage();
   //   }


            try {


               // System.out.println("current value: " + currentValue);
                // pItemitem.setItemQuantity(currentValue);
                // System.out.println(currentValue);
                if (plist == null) {
                    plist = new ArrayList<>(); // Initialize the ArrayList if it is null
                }
               // plist.add(pItemitem);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                // System.out.println(currentValue);
               // System.out.println(pItemitem);
               // System.out.println(currentValue);

                currentValue = SpinnerButton.getValue();
                while (currentValue>pItemitem.getItemQuantity() )
                {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Warning Alert Quantity");
                    alert.setContentText("Please Select  Less Quantity.. ");
                    alert.showAndWait();
                    Spinner<Integer> SpinnerButton = null;
                    SpinnerValueFactory<Integer> valueFactory= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);
                        try {
                            SpinnerButton.setValueFactory(valueFactory);
                        }catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }

                    currentValue=SpinnerButton.getValue();
                    if (currentValue <pItemitem.getItemQuantity() && SpinnerButton !=null)
                        break;
                }
                DoneButton.setDisable(false);

                Item itm = Customer.purchased(NamePurchaseSearch, currentValue, pItemitem);

                plist.add(itm);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            






    }

   public  Customer returncustomerProduct()
    {

        return c1;
    }


    public void purchasesButtonFunction(ActionEvent actionEvent) throws IOException {




            Stage stage = (Stage) purchasedButtonO.getScene().getWindow();
            FXMLLoader fx = new FXMLLoader(Main.class.getResource("ShowPurchase.fxml"));
            stage.setTitle("Admin");
            stage.setScene(new Scene(fx.load()));
            stage.show();





    }
    public static Customer rtnCustomer() throws IOException {

        try {
            oisp=new ObjectInputStream(new FileInputStream(file));
           Customer cs= (Customer) oisp.readObject();
           oisp.close();


           return cs;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    public void CustomerinPurchaseF(ActionEvent actionEvent) {


        /*else {

            try {
                c1.setCustomerName(NameCustomerPBlb.getText().trim());
                c1.setCustomerAddress(CityCustomerPLB.getText().trim());

                c1.setCustomerId(Integer.parseInt(IDCustomerPurchasetext.getText()));
                System.out.println(c1.getCustomerName());
                System.out.println(c1.getCustomerId());
                System.out.println(c1.getCustomerAddress());
            }catch (Exception e)
            {
                System.out.println("construct");
            }*/

        }

    public void CustomerAddbuttonF(MouseEvent mouseEvent) {
    }

    public void Donefunction(ActionEvent actionEvent) {

        System.out.println(plist);
        totalBll = Customer.checkout(plist);
        c1.setCustomerName(Main.nameCustomerp);
        c1.setCustomerId(Main.idCustomerP);
        c1.setCustomerAddress(Main.cityCustomerp);
        c1.setcCheckout(totalBll);
        c1.setcItem(plist);
        c1.setWorkingEmployee(workerName);
        DoneButton.setDisable(true);
        purchasedButtonO.setDisable(false);
        ADDPurchaseButtonB.setDisable(true);
        GoSearchButton.setDisable(true);

        //         System.out.println(workerName);
//
//
//        System.out.println(c1.getCustomerName() + "  "+ c1.getCustomerAddress() + "  "+c1.getCustomerId());
//
//       System.out.println(c1.getCustomerName() + c1.getcItem());
        try {

            oopS=new ObjectOutputStream(new FileOutputStream(file));

            oopS.writeObject(c1);
            oopS.close();

            Customer.addCustomer(c1);
        } catch (Exception e) {
            System.out.println("not working ascnasjkdncjkancjnjan");
        }
    }

    public void BackACustomerF(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) BackACustomerButton.getScene().getWindow();
        FXMLLoader fx = new FXMLLoader(Main.class.getResource("SaleEmployeeSc.fxml"));
        stage.setTitle("Administer");
        stage.setScene(new Scene(fx.load()));
        stage.show();
    }
}


