package OOPS_Concepts;

class Base {
    Base() {
        System.out.println(
                "Base Class Constructor Called ");
    }
}

class Derived extends Base {
    Derived() {
        super();
        System.out.println(
                "Derived Class Constructor Called ");
    }
}

public class Inheritance {

    public static void main(String[] args) {
        Derived d = new Derived();
    }
}
