/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null) return head;
        
        
        // dp 
        ListNode preNode = head;
        ListNode nextNode = head.next;
        while(nextNode != null){
            if(preNode.val == nextNode.val){
                nextNode = nextNode.next;
                preNode.next = nextNode;
            }
            else{
                preNode = preNode.next;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}