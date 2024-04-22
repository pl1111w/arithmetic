package tree.traversal;

import tree.common.TreeNode;

import java.util.Stack;

/**
 * @title: pl1111w
 * @description: 中序遍历
 * @author: Kris
 * @date 2024/4/21 10:48
 */
public class MidTraversal {

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);

        TreeNode leftNext = new TreeNode(2);

        TreeNode rightNext = new TreeNode(8);
        rightNext.setLeft(new TreeNode(7));
        rightNext.setRight(new TreeNode(9));

        right.setLeft(leftNext);
        right.setRight(rightNext);
        parent.setLeft(left);
        parent.setRight(right);
        midTraversalRecur(parent);
        System.out.println("+++++++++++middle traversal++++++++++++++");
        midTraversal(parent);
    }


    public static void midTraversalRecur(TreeNode treeNode) {
        if (treeNode == null)
            return;
        midTraversalRecur(treeNode.getLeft());
        System.out.println(treeNode.getVal());
        midTraversalRecur(treeNode.getRight());

    }

    public static void midTraversal(TreeNode treeNode) {
        if (treeNode == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = treeNode;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            TreeNode node = stack.pop();
            System.out.println(node.getVal());
            if (node.getRight() != null) {
                cur = node.getRight();
            }
        }
    }
}

