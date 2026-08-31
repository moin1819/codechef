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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // A critical point requires at least one preceding and one succeeding node.
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int currIdx = 1;

        int firstIdx = -1;
        int prevIdx = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            boolean isMax = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMin = curr.val < prev.val && curr.val < curr.next.val;

            if (isMax || isMin) {
                if (firstIdx == -1) {
                    firstIdx = currIdx;
                } else {
                    minDistance = Math.min(minDistance, currIdx - prevIdx);
                }
                prevIdx = currIdx;
            }

            prev = curr;
            curr = curr.next;
            currIdx++;
        }

        if (firstIdx == -1 || prevIdx == firstIdx) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevIdx - firstIdx;
        return new int[]{minDistance, maxDistance};
    }
}