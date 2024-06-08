import common.ListNode;

/**
 * @title: pl1111w
 * @description: 反转链表
 * @author: Kris
 * @date 2024/6/1 14:31
 */
public class ReverseListNode {

    public static void main(String[] args) {
        ReverseListNode reverseListNode = new ReverseListNode();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reverseListNode.reverse(node);
    }

    private void reverse(ListNode curr) {
        ListNode pre = null; //当前节点的前一个节点
        while (curr != null) { //要判断的节点为空
            ListNode next = curr.next;//把当前节点的下一个节点存起来
            curr.next = pre;//当前节点指向前一个节点
            pre = curr;//前驱节点后移
            curr = next;//当前节点后移动 判断下一个元素
        }
        System.out.println(pre);
    }
}
