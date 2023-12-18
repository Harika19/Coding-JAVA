package OopsSecondary.inheritanceSecondary;

import Oops.inheritanceA.ParentA;

abstract class ChildSecondary {

    public void printString() {
        ParentA parentA = new ParentA();
//        System.out.println("defaultPaypal     : "+parentA.defaultPaypal);
//        System.out.println("privateCleartrip  : "+parentA.privateCleartrip);
//        System.out.println("protectedGoogle   : "+parentA.protectedGoogle);
        System.out.println("publicAmazon      : "+parentA.publicAmazon);
    }
}
