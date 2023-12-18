package Abstraction;

import java.util.Scanner;

abstract class Employee {

    Scanner s = new Scanner(System.in);
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    void m1(){
        System.out.println("Name :"+name);
        System.out.println("id = " + id);
    }
}

class softEng extends Employee {

    public softEng(String name, int id) {
        super(name, id);
    }


    public static void main(String[] args) {
        softEng e = new softEng("pratik", 121);
        e.m1();
    }

}