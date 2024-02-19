package OOPS_Concepts;


class A{
    A(){
        System.out.println("A ");
    }
    A(int a){
        System.out.println("A-param"+ a);
    }


}

class C extends  A{
    C(){
        System.out.println("C ");
    }
    C(int a){
        System.out.println("C-param"+ a);
    }

    public void show(){
        System.out.println("C-A SHOWW");
    }


}

class B extends C{
    B(){
        System.out.println("B ");
    }
    B(int b){
        //super(2);
        this(); // A     C     B       B-param8     B-C SHOWW
        System.out.println("B-param"+ b);
    }
    public void show(){
        System.out.println("B-C SHOWW");
    }
}
public class ThisAndSuper {
    public static void main(String[] args) {
        //B obj = new B(); // A B
        //B obj1 = new B(1); //A B-param
        //B obj2 = new B(11); //A-param B-param => super
        B obj3 = new B(8); // this => A B B-param8 => other constructor in same class gets executed then invisible super in B() calls A()..
        obj3.show(); // B-C SHOWW=> method overring
    }
}
