package Blind75.LinkedList;

class ListNode4 {
      int val;
      ListNode4 next;
      ListNode4() {}
      ListNode4(int val) { this.val = val; }
      ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
  }

public class LC_234_Palindrome_LinkedList {
    private static ListNode4 reverse(ListNode4 node){
        ListNode4 temp = node;
        ListNode4 prev = null;
        while(temp!=null){
            ListNode4 next = temp.next;
            temp.next = prev;
            prev= temp;
            temp= next;
        }
        return prev;

    }
//    public static boolean isPalindrome(ListNode4 head) {
//        ListNode4 slow = head;
//        ListNode4 fast = head;
//        while(fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//
//         reverse(slow);
//        while(head!=null){
//            System.out.println(head.val);
//            head= head.next;
//        }
//        return true;
//    }
    private static boolean isPalindrome(ListNode4 head) {
        // Check if no elements or only one element
        if (head == null || head.next == null) {
            return true;
        }

        ListNode4 slow = head, fast = head;

        // Find the middle element
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);

        // Reverse the second half
        slow.next = reverse(slow.next);
        System.out.println(slow.val);

        // Move slow to one step forward
        slow = slow.next;
        System.out.println(slow.val);

        // Start a pointer from the start and slow from the mid
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }
    public static void main(String[] args) {
        ListNode4 head = new ListNode4(1, new ListNode4(2, new ListNode4(2, new ListNode4(1))));
        boolean res = isPalindrome(head);
        System.out.println(res);
    }
}
