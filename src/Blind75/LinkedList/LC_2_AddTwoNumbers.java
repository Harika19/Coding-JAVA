package Blind75.LinkedList;

 class ListNode {
    int val;
     ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LC_2_AddTwoNumbers {
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode temp = new ListNode();
    ListNode curr = temp;

    while(l1!= null || l2 != null || carry!=0){
        int sum =0;
        if(l1!=null){
            sum+= l1.val;
            l1=l1.next;
        }
        if(l2!=null){
            sum+= l2.val;
            l2=l2.next;
        }
        sum += carry;
        carry = (sum/10);
        ListNode newnode = new ListNode(sum % 10);
        curr.next = newnode;
        curr = curr.next;

    }

    return temp.next;
}

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = addTwoNumbers(l1, l2);

        // Iterate over the result and print each value
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
