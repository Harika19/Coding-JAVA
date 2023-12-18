package Oops.Abstraction;

public class Caller {

    public void call(){
        AbstractTest abstractTest = new AbstractTest_Extend(); //ask Gowthy
        abstractTest.printNumber();
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.call();
    }
}
