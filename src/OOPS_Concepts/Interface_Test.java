package OOPS_Concepts;


interface A3{
    int number = 11; // final and static
    void print();
    void show();
}

class B3 implements A3{

    @Override
    public void print() {
        System.out.println("printtttt");
    }

    @Override
    public void show() {
        System.out.println("showwww");
    }
}
public class Interface_Test {
    public static void main(String[] args) {
        B3 obj = new B3();
        obj.print();
        obj.show();
        // A3.number = 13; wrong as it is final , u cannot re-assign
        System.out.println(A3.number);
    }
}
