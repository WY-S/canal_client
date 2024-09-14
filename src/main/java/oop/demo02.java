package oop;
//值传递和引用传递的区别。
public class demo02 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);

        demo02.change(a);
        System.out.println(a);

        person p = new person();
        System.out.println(p.name);

        demo02.change(p);
        System.out.println(p.name);
    }

    public static void change(int a){
        a=10;
    }

    public static void change(person a){
        a.name="www";
    }

}


