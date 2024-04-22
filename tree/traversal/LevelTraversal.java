package tree.traversal;

import tree.common.TreeNode;

import java.util.Stack;

/**
 * @title: pl1111w
 * @description: 层级遍历
 * @author: Kris
 * @date 2024/4/22 9:39
 */
public class LevelTraversal {

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
        levelTraversal(parent);
    }

    private static void levelTraversal(TreeNode parent) {
        if (parent == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(parent);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.getVal());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }
}
