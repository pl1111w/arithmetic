package tree.common;

/**
 * @title: pl1111w
 * @description:
 * @author: Kris
 * @date 2024/4/21 10:09
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    Integer val;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
