package Oops.Abstraction;

public class AbstractTest_Extend extends AbstractTest {
    @Override
    public int printNumber() {
        System.out.println(" Number : "+this.number);
        return this.number;
    }

}
