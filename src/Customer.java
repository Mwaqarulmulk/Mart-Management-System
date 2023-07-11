//FA22



import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer implements Serializable{
    private int customerId;
    private String customerName;
    private String customerAddress;
    private ArrayList<Item> cItem;
    private double cCheckout;
    private String WorkingEmployee;
    LocalDateTime now = LocalDateTime.now();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Customer> listCustomer = new ArrayList<>();
    // static ArrayList<Item> pItemlist;

    static File cfile = new File("BCustomer.dat");
    static ObjectOutputStream cof = null;
    static ObjectInputStream cif;

    public Customer() {

    }

    public String getWorkingEmployee() {
        return WorkingEmployee;
    }

    public void setWorkingEmployee(String workingEmployee) {
        WorkingEmployee = workingEmployee;
    }

    static {
        try {
            cif = new ObjectInputStream(new FileInputStream(cfile));

        } catch (IOException e) {

            e.getMessage();
        }
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public Customer(int customerId, String customerName, String customerAddress, ArrayList<Item> cItem, double cCheckout) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.cItem = cItem;
        this.cCheckout = cCheckout;



    }

    public ArrayList<Item> getcItem() {
        return cItem;
    }

    public void setcItem(ArrayList<Item> cItem) {

        this.cItem = cItem;
    }

    public double getcCheckout() {
        return cCheckout;
    }

    public void setcCheckout(double cCheckout) {
        this.cCheckout = cCheckout;
    }



    ;

    public Customer(int customerId, String customerName, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;

        // pItemlist=new ArrayList<>();


    }

//        public static ArrayList<Customer> reCustomer(String namePass)
//        {
//            ArrayList<Customer> tlisOfCustomer = new ArrayList<>();
//            try {
//
//                cif=new ObjectInputStream(new FileInputStream(cfile));
//                listCustomer=(ArrayList<Customer>)cif.readObject();
//                cif.close();
//
//              //  System.out.println(listCustomer.size());
//
//                for (int i = 0; i < listCustomer.size(); i++) {
//                    if (listCustomer.get(i).getWorkingEmployee().equals(namePass))
//                    {
//                        System.out.println(listCustomer.get(0).getWorkingEmployee());
//                        tlisOfCustomer.add(listCustomer.get(i));
//                        System.out.println(tlisOfCustomer.get(0).getWorkingEmployee());
//                    }
//
//                }
//                return tlisOfCustomer;
//            }catch (FileNotFoundException e)
//            {
//                e.getMessage();
//            }
//            catch (ObjectStreamException e)
//            {
//                e.getMessage();
//            }
//            catch (IOException e)
//            {
//                e.getMessage();
//            }
//            catch (ClassNotFoundException e)
//            {
//                System.out.println("Class Not Found Exception");
//            }
//            return null;
//
//        }

    public static ArrayList<Customer> reCustomer(String namePass) {
        ArrayList<Customer> listOfCustomers = new ArrayList<>();
        try {
            ObjectInputStream cif = new ObjectInputStream(new FileInputStream(cfile));
             listCustomer = (ArrayList<Customer>) cif.readObject();
            cif.close();

            for (int i = 0; i < listCustomer.size(); i++) {
                if (listCustomer.get(i).getWorkingEmployee().equals(namePass)) {
                    System.out.println(listCustomer.get(i).getWorkingEmployee());
                    listOfCustomers.add(listCustomer.get(i));
                    System.out.println(listOfCustomers.get(0).getWorkingEmployee() + "sduc");
                }
            }
            return listOfCustomers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ObjectStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception");
        }
        return null;
    }



    public static void addCustomer(Customer customer) {
        try {
            cif=new ObjectInputStream(new FileInputStream(cfile));
            listCustomer=(ArrayList<Customer>)cif.readObject();
            cif.close();
            listCustomer.add(customer);
            cof = new ObjectOutputStream(new FileOutputStream(cfile));
            cof.writeObject(listCustomer);
            cof.close();
        }catch (IOException e)
        {
            System.out.println("IOn Exception");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public static ArrayList<Customer> cDisplay()
    {
        try {
            cif=new ObjectInputStream(new FileInputStream(cfile));
            listCustomer=(ArrayList<Customer>)cif.readObject();
            cif.close();
            return listCustomer;
        }catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (ObjectStreamException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Not Found Exception");
        }
        return null;
    }



    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }



    public static Customer cSearch(int id)
    {
        try {
            cif=new ObjectInputStream(new FileInputStream(cfile));
            listCustomer=(ArrayList<Customer>)cif.readObject();
            cif.close();
            for (int i = 0; i < listCustomer.size(); i++) {
                if(listCustomer.get(i).getCustomerId()==id)
                    return listCustomer.get(i);

            }


        }catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (ObjectStreamException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Not Found Exception");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.getMessage();
        }
        return (new Customer(0,null,null,null,0));

    }




    public static Item purchased(String namec,int quantityc, Item item) throws IOException, ClassNotFoundException {
        Item tm = new Item(0, namec, 0, 0);



        Item pItem = new Item(item.getItemId(), item.getItemName(), item.getItemPrice(), quantityc);
        Item itm = Item.searchItem(namec);
       // System.out.println(quantityc);
        Item.updateItem(tm, new Item(item.getItemId(), item.getItemName(), item.getItemPrice(),(item.getItemQuantity()-quantityc)));
        //pItemlist.add(pItem);
        //System.out.println(pItem);
        return pItem;


    }
    public static double checkout(ArrayList<Item> tlistSales) {
        double sum=0;
       try
       {

           for (int i = 0; i < tlistSales.size(); i++) {
               sum=sum+(tlistSales.get(i).getItemPrice()*tlistSales.get(i).getItemQuantity());

           }

       }catch(Exception e)
       {
           e.getMessage();
       }


        return sum;
    }

    @Override
    public String toString() {


        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", cItem=" + cItem +
                ", cCheckout=" + cCheckout +
                ", now=" + now +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getCustomerId() == customer.getCustomerId() && Double.compare(customer.getcCheckout(), getcCheckout()) == 0 && Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getCustomerAddress(), customer.getCustomerAddress()) && Objects.equals(getcItem(), customer.getcItem()) && Objects.equals(getWorkingEmployee(), customer.getWorkingEmployee()) && Objects.equals(getNow(), customer.getNow());
    }


}