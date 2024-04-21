package tree.traversal;

import tree.common.TreeNode;

import java.util.Stack;

/**
 * @title: pl1111w
 * @description: 后续遍历
 * @author: Kris
 * @date 2024/4/21 10:51
 */
public class PostTraversal {

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
        preTraversalRecur(parent);
        System.out.println("+++++++++++post traversal++++++++++++++");
        postTraversal(parent);

    }


    public static void preTraversalRecur(TreeNode treeNode) {
        if (treeNode == null)
            return;
        preTraversalRecur(treeNode.getLeft());
        preTraversalRecur(treeNode.getRight());
        System.out.println(treeNode.getVal());

    }

    public static void postTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> printJust = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            printJust.push(node);
            //left后出栈 然后被压入printJust才会在上面
            if (node.getLeft() != null)
                stack.push(node.getLeft());
            if (node.getRight() != null)
                stack.push(node.getRight());
        }
        while (!printJust.isEmpty()) {
            System.out.println(printJust.pop().getVal());
        }
    }
}
