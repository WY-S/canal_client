package oop;

public class person1 {

    public person1(){
        System.out.println("Person1无参执行了");
    }

    protected String name = "wenyi_person";

    //private 无法被继承
    public void print(){
        System.out.println("Person");
    }
}
