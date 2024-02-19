package Oops.inheritanceA;

import Oops.InheritanceB.ChildB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Driver {


    public static void main(String[] args) {
        ParentA parentA= new ParentA();

        ParentA parentA2= new ChildB();


        ParentA parentA1= new ChildA(); // u will have access to only ParentA methods but not child class methods
        parentA1.getString();
       // parentA1.getStringChild();

        ChildA childA = new ChildA(); // full access , both parent and child

        childA.getString();
        childA.getStringChild("jjj");


        List<Integer> obj = new ArrayList<>();
        List<Integer> obj1 = new LinkedList<>();
    }
}
