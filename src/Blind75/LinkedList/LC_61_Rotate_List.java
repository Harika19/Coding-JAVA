package Blind75.LinkedList;
class ListNode3 {
      int val;
      ListNode3 next;
      ListNode3() {}
      ListNode3(int val) { this.val = val; }
      ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
  }
public class LC_61_Rotate_List {
    public static ListNode3 rotateRight(ListNode3 head, int k) {
        if(head==null || head.next==null || k==0 ) return  head;
        int c=1;
        ListNode3 curr = head;
        while (curr.next!=null){
            c+=1;
            curr= curr.next;
        }
        curr.next=head;
        k= c- (k%c);
        while (k-- >0) curr=curr.next;
        head = curr.next;
        curr.next=null;
        return head;
    }
    public static void main( String[] args) {
        ListNode3 head = new ListNode3(1,new ListNode3(2, new ListNode3(3,new ListNode3(4, new ListNode3(5)))));
        int k = 2;
        ListNode3 res = rotateRight(head, k);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }

    }
}
