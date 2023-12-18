package Blind75.LinkedList;

class ListNode2{
    int value;
    ListNode2 next;
    ListNode2(){}
    ListNode2(int value){
        this.value= value;
    }
    ListNode2(int value, ListNode2 next){
        this.value= value;
        this.next = next;
    }
}
public class LC_19_Remove_Nth_Node_From_End_of_List {
    public static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 temp = new ListNode2();
        temp.next= head;
        ListNode2 fast = temp;
        ListNode2 slow = temp;
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        while(fast !=null){
            fast = fast.next;
            slow= slow.next;
        }
        slow.next= slow.next.next;
        return temp.next;

    }
    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1, new ListNode2(2, new ListNode2(3, new ListNode2(4, new ListNode2(5)))));
        int n=2;
        ListNode2 res = removeNthFromEnd(head, n);
        while (res != null) {
            System.out.print(res.value + " "); // print -> to print in same lin e , println -> diff line
            res = res.next;
        }
    }
}
