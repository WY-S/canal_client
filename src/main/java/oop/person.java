package oop;

public class person {

    //一个类即使什么都不写，它也会存在一个方法，就是构造方法
    //显示的定义构造器
    //属性
    String name;
    //实例化
    //1. 使用new关键自，本质是在调用构造器
    //2. 用来初始化值

    //无参构造
    public person(){
        this.name = "wenyi";
    }

    //有参构造: 一旦定义了有参构造，无参构造就必须显示定义
    public person(String name){
        this.name=name;
    }

    public void run(){
        System.out.println("run");
    }

    public void hello(){
        System.out.println("hello");
    }

}
