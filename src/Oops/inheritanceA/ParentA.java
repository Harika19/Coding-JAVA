package Oops.inheritanceA;

public class ParentA {

    // default access modifier is also called package-private
    String defaultPaypal = "PayPal";
    private String privateCleartrip = "Cleartrip";
    // we can access the member from the same package (as with package-private access level)
    // and in addition from all subclasses of its class, even if they lie in other packages:
    protected String protectedGoogle = "Google"; // inheritance - it works ,
    // but when we create obj in other package and access protected it won't work.
    public String publicAmazon = "Amazon";

    public void printString() {
        System.out.println("defaultPaypal     : "+ defaultPaypal);
        System.out.println("privateCleartrip  : "+privateCleartrip);
        System.out.println("protectedGoogle   : "+protectedGoogle);
        System.out.println("publicAmazon      : "+publicAmazon);
    }

    public String getString() {
        System.out.println(" Parent : "+publicAmazon);
        return publicAmazon;
    }
}
