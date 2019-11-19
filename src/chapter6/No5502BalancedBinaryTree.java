package chapter6;

import chapter2.TreeNode;

/**
 * Description: SwordOffer
 * time: 2019-11-19 16:32
 */
//给定一棵二叉树,判断是否是平衡二叉树
public class No5502BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;
        No5502BalancedBinaryTree no5502BalancedBinaryTree = new No5502BalancedBinaryTree();
        System.out.println(no5502BalancedBinaryTree.isBalancedBinaryTree(node1));
    }

    boolean isBalanced = true;
    private boolean isBalancedBinaryTree(TreeNode root){
        if (root == null){
            return true;
        }
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        int diff = leftDepth-rightDepth;
        if (diff > 1 || diff < -1){
            isBalanced = false;
        }
        return Math.max(leftDepth, rightDepth)+1;
    }


}
