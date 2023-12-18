package Oops.InheritanceB;

import Oops.inheritanceA.ParentA;

public class ChildB extends ParentA {

    public void printString() {
//        System.out.println("defaultPaypal     : "+defaultPaypal);
//        System.out.println("privateCleartrip  : "+privateCleartrip);
        System.out.println("protectedGoogle   : "+protectedGoogle);
        System.out.println("publicAmazon      : "+publicAmazon);
    }
}
