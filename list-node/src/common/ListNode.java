package common;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2024/4/16 9:23
 */
public class ListNode {

    public ListNode next;

    int val;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
