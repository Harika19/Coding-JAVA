package OOPS_Concepts;

//When you don’t want to create an obj for abstract class …

abstract class A2{ // for abstract methods , abstract must be used before class
    abstract void test2(); // abstract method should only be declared here
    public void test(){
        System.out.println("test");
    }
}

class B2 extends A2{
    void test2(){ // all abstract methods should be defined here
        System.out.println("test2");
    }
}

class B3 extends A2{
    void test3(){ // all abstract methods should be defined here
        System.out.println("test2");
    }

    @Override
    public void test(){
        System.out.println("Overrided test3");
    }
}

public class Abstract_Test {
    public static void main(String[] args) {
        B2 obj = new B2(); // obj cannot be created fo abstract classes
        obj.test2();
        obj.test();
    }
}
