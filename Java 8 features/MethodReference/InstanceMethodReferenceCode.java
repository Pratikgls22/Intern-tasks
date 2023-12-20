package MethodReference;

interface Employee{
    void name();
    static void Salary(){
        System.out.println(100000);
    };
}

public class InstanceMethodReferenceCode {

    public void SayName(){
        System.out.println("Prtaik");
    }

    public void SaySalary(){
        System.out.println(50000);
    }


    public static void main(String[] args) {
        InstanceMethodReferenceCode imr = new InstanceMethodReferenceCode();
        Employee info = imr::SayName;

        info.name();
        InstanceMethodReferenceCode imr2 = new InstanceMethodReferenceCode();
        Employee.Salary();

    }
}
