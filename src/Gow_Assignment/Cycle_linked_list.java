package Gow_Assignment;

import java.util.List;

class ListNode_1{
    int val;
    ListNode_1 next;
    ListNode_1(){}
    ListNode_1(int val){
        this.val= val;
    }
    ListNode_1(int val,ListNode_1 next ){
        this.val=val;
        this.next= next;
    }
}
public class Cycle_linked_list {
    private boolean linked_list(ListNode_1 list){
        ListNode_1 slow = list;
        ListNode_1 fast = list;
        while (fast!=null && fast.next !=null){
            slow= slow.next;
            fast= fast.next.next;
            if (slow==fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode_1 node1=new ListNode_1(1);
        ListNode_1 node2=new ListNode_1(2);
        ListNode_1 node3=new ListNode_1(3);
        ListNode_1 node4=new ListNode_1(4);
        node1.next=  node2;
        node2.next=node3;
        node3.next= node4;
        node4.next= node2;
        Cycle_linked_list obj = new Cycle_linked_list();
        System.out.println(obj.linked_list(node1));
    }
}
