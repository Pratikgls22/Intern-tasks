package encapsulation;

public class Student {
    private String Name;
    private int RollNo;
    public void setName(String na){
        Name = na;
    }
    public void setRollNo(int ro_no){
        RollNo = ro_no;
    }

    public String getName(){
        return Name;
    }
    public int getRollNo(){
        return RollNo;
    }
}

class Information{
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("pratik");
        s.setRollNo(101);

        System.out.println("Student Name is :"+s.getName());
        System.out.println("Student RollNo is :"+s.getRollNo());

    }
}
