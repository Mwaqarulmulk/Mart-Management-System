//FA22


import java.io.*;
import java.util.ArrayList;

public class Employee implements Serializable{

    private int id;
    private String name;
    private String Address;
    private double salary;
    private String userName;
    private String password;
    public static int LoginCount;



    public static ArrayList<Employee> employeelist=new ArrayList<>();
    static File efile = new File("BEmployee.dat");
    static ObjectOutputStream oose = null;
    static ObjectInputStream oise;

    static {
        try {
            oise = new ObjectInputStream(new FileInputStream(efile));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }


   /* Employee()
    {
        try {
            eoos=new ObjectOutputStream(new FileOutputStream(efile));
        } catch (IOException e) {

        }

        try {
            eois=new ObjectInputStream(new FileInputStream(efile));
        } catch (IOException e) {

        }
    }*/

    public Employee(int id, String name,double salary, String address,String userName, String password) {
        this.id = id;
        this.name = name;
        this.Address = address;
        this.salary=salary;

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void addEmployee(Employee employee)
    {
        readListofEmployee();

        try {
            employeelist.add(employee);
            oose=new ObjectOutputStream(new FileOutputStream(efile));
            oose.writeObject(employeelist);
            oose.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static ArrayList<Employee> readEmployee() throws IOException, ClassNotFoundException {

        try {

            oise=new ObjectInputStream(new FileInputStream(efile));
            ArrayList<Employee> remployeelist=(ArrayList<Employee>)oise.readObject();
            oise.close();


                    return remployeelist;
        }
        catch (ObjectStreamException e)
        {
            e.getMessage();
        }
        catch (EOFException e)
        {
            e.getMessage();
        }catch (ArrayIndexOutOfBoundsException e)
        {
            e.getMessage();
        }



        return null;

    }

    public static void readListofEmployee()
    {
        try {
            oise = new ObjectInputStream(new FileInputStream(efile));
            employeelist = (ArrayList<Employee>) oise.readObject();
            oise.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Employee searchEmployee(String names)
    {

        try {
            oise=new ObjectInputStream(new FileInputStream(efile));
            employeelist=(ArrayList<Employee>)oise.readObject();
            oise.close();
            for (int i = 0; i < employeelist.size(); i++) {
                if (employeelist.get(i).getName().equals(names))
                    return employeelist.get(i);

            }

        } catch (IOException e) {
            System.out.println("IO Exception");;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class NOt Found Exception");
        }
        return new Employee(0,null,0,null,null,null);

    }

    public static void updateEmployee(Employee em,Employee employee)
    {
        try
        {
            oise=new ObjectInputStream(new FileInputStream(efile));
            employeelist=(ArrayList<Employee>)oise.readObject();
            oise.close();
            for (int i = 0; i < employeelist.size(); i++) {
                if (employeelist.get(i).getName().equals(em.getName()))
                {
                    int j=employeelist.indexOf(employeelist.get(i));

                    employeelist.set(j,employee);

                }

            }
            oose=new ObjectOutputStream(new FileOutputStream(efile));
            oose.writeObject(employeelist);
            oose.close();
        }
        catch (ObjectStreamException e)
        {
            e.getMessage();
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }catch (ArrayIndexOutOfBoundsException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {

        }
        catch (ClassNotFoundException e)
        {
            e.getMessage();
        }
    }

    public static void dplay()
    {
        try {
            oise = new ObjectInputStream(new FileInputStream(efile));
            employeelist = (ArrayList<Employee>) oise.readObject();
            oise.close();
            System.out.println(employeelist.toString());
        }
        catch (EOFException e)
        {
            e.getMessage();
        }catch (ArrayIndexOutOfBoundsException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {

        }
        catch (ClassNotFoundException e)
        {
            e.getMessage();
        }

    }

    public static boolean LoginCheck(String userNamecheck ,String passwordCheck)
    {
        try {

            oise=new ObjectInputStream(new FileInputStream(efile));
            employeelist=(ArrayList<Employee>)oise.readObject();

            oise.close();
            for (int i = 0; i < employeelist.size(); i++) {
                if (employeelist.get(i).getUserName().equals(userNamecheck)) {
                    if (employeelist.get(i).getPassword().equals(passwordCheck)) {
                        EmployeeLoginSc.WorkingEmployeeDSale=employeelist.get(i).getName();
                        return true;
                    }
                }

            }

        }catch (Exception e)
        {
            e.getMessage();
        }
        return false;
    }
    public static void deleteEmployee(String nameds)
    {
        try
        {
            oise=new ObjectInputStream(new FileInputStream(efile));
            employeelist=(ArrayList<Employee>)oise.readObject();
            oise.close();
            for (int i = 0; i < employeelist.size(); i++) {
                if (employeelist.get(i).getName().equals(nameds))
                {
                    employeelist.remove(employeelist.get(i));
                }

            }
            oose=new ObjectOutputStream(new FileOutputStream(efile));
            oose.writeObject(employeelist);
            oose.close();
        }
        catch (ObjectStreamException e)
        {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }catch (ArrayIndexOutOfBoundsException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {

        }
        catch (ClassNotFoundException e)
        {
            e.getMessage();
        }
    }

    @Override
    public String toString() {
        return "" +
                "" + id +
                ",     '" + name + '\'' +
                ",     '" + Address + '\'' +
                ",     '" + password ;
    }
}
