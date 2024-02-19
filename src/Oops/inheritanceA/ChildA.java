package Oops.inheritanceA;

public class ChildA extends ParentA {

    @Override
    public void printString() {
        System.out.println("defaultPaypal     : "+ defaultPaypal);
        //System.out.println("privateCleartrip  : "+privateCleartrip);
        System.out.println("protectedGoogle   : "+protectedGoogle);
        System.out.println("publicAmazon      : "+publicAmazon);
    }

    public String getStringChild(String str) {
        System.out.println(" Parent : "+publicAmazon);
        return publicAmazon;
    }

}
