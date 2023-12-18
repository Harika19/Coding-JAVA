package OOPS_Concepts;

interface A4{
    int number = 11; // final and static
    void print();
    void show();
}
interface C4{
    void print1();
}

class B4 implements A4,C4{

    @Override
    public void print() {
        System.out.println("printtttt");
    }

    @Override
    public void show() {
        System.out.println("showwww");
    }

    @Override
    public void print1() {
        System.out.println("otherrrrr");
    }
}

public class Multi_Interface {
    public static void main(String[] args) {
        B4 obj = new B4();
        obj.print();
        obj.show();
        obj.print1();
        // A3.number = 13; wrong as it is final , u cannot re-assign
        System.out.println(A4.number);
    }
}
