package OOPS_Concepts;


class A1{
    A1(){
        System.out.println("A1");
    }

    public void show(){
        System.out.println("A1 SHOWW");
    }

}

class B1 extends A1{
    B1(){
        System.out.println("B1");
    }

    public void show(){
        System.out.println("B1 SHOWW");
    }
}

class C1 extends A1{
    C1(){
        System.out.println("C1");
    }

    public void show(){
        System.out.println("C1 SHOWW");
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        A1 obj = new B1(); // same type A1 on left side but diff forms i.e objs B1, C1
        obj.show();
        obj = new C1();
        obj.show();
    }
}
