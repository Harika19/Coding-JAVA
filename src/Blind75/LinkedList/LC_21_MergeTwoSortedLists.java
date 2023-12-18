package Blind75.LinkedList;
class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(){}
    ListNode1(int val){
        this.val= val;
    }
    ListNode1(int val, ListNode1 next){
        this.val= val;
        this.next= next;
    }

}

public class LC_21_MergeTwoSortedLists {
    public static ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) {
        ListNode1 temp = new ListNode1();
        ListNode1 prev = temp;
        if(list1==null) return list2;
        if(list2==null) return  list1;
        while (list1 !=null && list2!=null){
            if(list1.val<=list2.val){
                prev.next= list1;
                prev= list1;
                list1= list1.next;
            }else{
                prev.next= list2;
                prev= list2;
                list2= list2.next;
            }
        }
        if(list1!=null) prev.next= list1;
        if(list2!=null) prev.next= list2;
        return temp.next;
    }
    public static void main(String[] args) {
        ListNode1 list1= new ListNode1(1, new ListNode1(2, new ListNode1(4)));
        ListNode1 list2= new ListNode1(1, new ListNode1(3, new ListNode1(4)));
        ListNode1 res = mergeTwoLists(list1, list2);
        while (res!=null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
