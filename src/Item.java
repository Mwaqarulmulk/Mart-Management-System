//FA22


import javafx.collections.ObservableArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Item implements Serializable {
    static File file = new File("BItem.dat");
    static ObjectOutputStream oof = null;
    static ObjectInputStream oif;

    static {
        try {
            oif = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    private int itemId;
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private int perItemQuantity;

    public int getPerItemQuantity() {
        return perItemQuantity;
    }

    public void setPerItemQuantity(int perItemQuantity) {
        this.perItemQuantity = perItemQuantity;
    }

    static ArrayList<Item> itemList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public Item(int itemId, String itemName, double itemPrice, int itemQuantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }




    public static Item prch(int id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).itemId == id) {
                return new Item(itemList.get(i).itemId, itemList.get(i).getItemName(), itemList.get(i).itemPrice, 1);
            }


        }
        return Item.itemList.get(0);
    }


    public static void forP(int id) throws IOException {
        for (int i = 0; i < itemList.size(); i++) {

            if (itemList.get(i).getItemId() == id) {
                Item.itemList.get(i).setItemQuantity(itemList.get(i).getItemId() - 1);
                if (file.isFile()) {
                    oof = new ObjectOutputStream(new FileOutputStream(file));
                    oof.writeObject(itemList);
                    oof.close();
                }
            }

        }

    }


//ItemList All Function

    public static void additem(Item item) throws IOException {

        try {
            readlist();
            itemList.add(item);
            oof = new ObjectOutputStream(new FileOutputStream(file));
            oof.writeObject(itemList);
            oof.close();
        }
        catch (ObjectStreamException e)
        {
            System.out.println("File Error");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ReStart Program");
        }

    }

    public static void readlist()
    {
        if (file.isFile()) {
            try {
                oif = new ObjectInputStream(new FileInputStream(file));
                itemList = (ArrayList<Item>) oif.readObject();
                oif.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
    public static Item eqal(Item item) throws IOException, ClassNotFoundException {

        if (file.isFile()) {
            oif = new ObjectInputStream(new FileInputStream(file));
            itemList = (ArrayList<Item>) oif.readObject();
            oif.close();
        }
        for (int i = 0; i < itemList.size(); i++) {

            if (itemList.get(i).itemId == item.itemId) {
                return itemList.get(i);
            }

        }
        return item;
    }

    public static void updateItem(Item indexItem,Item uItem) throws IOException {
        try
        {
            readlist();
            oif=new ObjectInputStream(new FileInputStream(file));
            itemList = (ArrayList<Item>) oif.readObject();
            oif.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File is NOt Working");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {


            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).getItemName().equals(indexItem.getItemName())) {
                    int j = itemList.indexOf(itemList.get(i));

                    itemList.set(j, uItem);
                    oof = new ObjectOutputStream(new FileOutputStream(file));
                    oof.writeObject(itemList);
                    oof.close();
                }

            }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Item NOt Update");
        }

    }

    public static void deleteItem(String itemNamed) throws IOException, ClassNotFoundException {

        readlist();
            if (file.isFile()) {
                oif = new ObjectInputStream(new FileInputStream(file));
                itemList = (ArrayList<Item>) oif.readObject();
                oif.close();
            }

            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).itemName.equals(itemNamed)) {

                    itemList.remove(i);
                    if (file.isFile()) {
                        oof = new ObjectOutputStream(new FileOutputStream(file));
                        oof.writeObject(itemList);
                        oof.close();
                    }
                }
            }




    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public static Item searchItem(String itemNAmeo) throws IOException, ClassNotFoundException {
        try {
            if (file.isFile()) {
                oif = new ObjectInputStream(new FileInputStream(file));
                itemList = (ArrayList<Item>) oif.readObject();
                oif.close();

            }
        }
        catch (ObjectStreamException e)
        {
            System.out.println("FIle Error");;
        }

            try {
                for (int i = 0; i < itemList.size(); i++) {

                    if (itemList.get(i).itemName.equals(itemNAmeo)) {
                        return itemList.get(i);
                    }
                }

            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println("Zero Record");
            }
        return new Item(0,null,0,0);

    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public static ArrayList<Item> display() throws IOException, ClassNotFoundException {
        try {

            oif = new ObjectInputStream(new FileInputStream(file));
            itemList = (ArrayList<Item>) oif.readObject();
            oif.close();

            //   for (int i = 1; i < Item.itemList.size(); i++) {
            //
            //
            //       System.out.println(Item.itemList.get(i).toString());
            //   }
            return itemList;


        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (ObjectStreamException e) {
            e.getMessage();
        } catch (EOFException e) {
            System.out.println("First Create File to Read Data By enter Products...");
        }
               return null;

    }



    @Override
    public String toString() {


        return "" +
                "" + itemId +
                "      \t" + itemName +
                "      \t" + itemPrice +
                "      \t" + itemQuantity ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return itemId == item.itemId && Double.compare(item.itemPrice, itemPrice) == 0 && itemQuantity == item.itemQuantity && Objects.equals(itemName, item.itemName) && itemList.equals(item.itemList);
    }







}
