package KeyWord;

class Employee{
    private int id;
    String name;
    static String CompanyName = "Softvan";

    Employee(int i, String n){
        this.id = i;
        this.name = n;
        System.out.println("Empolyee INFO  "+ "NAME: "+name+" Id:"+id);
    }
}

public class StaticKey {
    public static void main(String[] args) {

        Employee e = new Employee(101,"pratik");
    }
}
