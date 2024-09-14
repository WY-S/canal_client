package oop;

import java.sql.SQLOutput;

public class demo01 {
    public static void main(String[] args) {
        /*
        person person = new person();

        System.out.println(person.name);

        person per2 = new person("www");

        System.out.println(per2.name);

        student st = new student();
        st.test("wenyi");
        st.test1();

        A a = new A();
        a.test();
        a.test2();
        System.out.println(a.value);

        B b = new A();
        b.test();
        b.test2();
        System.out.println(b.value);
         */

        Teacher s1 = new Teacher();
        person s2 = new Teacher();
        Object s3 = new Teacher();

        s1.run();
        s2.run();
        s1.eat();
        //s2.eat();
        //s3.eat();
        s1.hello();


    }

    public String sayHello(){
        return "hello world";
    }

    public int maxValue(int a, int b){
        return a>b?a:b;
    }

    public int maxValue(int a, int b, int c){
        return a>b?a:b;
    }

}

