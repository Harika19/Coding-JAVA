package Oops.Abstraction;

public interface InterfaceTest {

    int number = 10;

    public default int printNumber(){
        return number;
    }
}


