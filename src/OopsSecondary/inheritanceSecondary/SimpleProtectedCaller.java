package OopsSecondary.inheritanceSecondary;

import Oops.inheritanceA.ParentA;

public class SimpleProtectedCaller extends ParentA{

    public void printString() {
//        System.out.println("defaultPaypal     : "+defaultPaypal);
//        System.out.println("privateCleartrip  : "+privateCleartrip);
        System.out.println("protectedGoogle   : "+protectedGoogle);
        System.out.println("publicAmazon      : "+publicAmazon);
    }
}
