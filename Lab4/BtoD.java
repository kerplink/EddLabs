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
class BtoD {
    public int getDecimalValue(ListNode head) {
        String binaryString="0";
        ListNode n = head;
        int decimal = 0;
        while(n !=null){
            binaryString = binaryString+n.val;
            n = n.next;
        }
        return Integer.parseInt(binaryString, 2);
    }
}
