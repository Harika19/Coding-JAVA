package OOPS_Concepts;

@FunctionalInterface // should have only 1 method
interface A5{
    void show();
}
public class Lambda_Test {
    public static void main(String[] args) {
        // without have one more class
        A5 obj = new A5() {
            @Override
            public void show() {
                System.out.println("hiiii");
            }
        };
        obj.show();


        // lambda
        A5 obj1 = () -> { // brackets are also nor required if 1 statement is there but if return you need to have braces
            System.out.println("lambdaaa");
        };
        obj1.show();
    }
}
