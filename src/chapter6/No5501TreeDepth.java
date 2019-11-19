package chapter6;

import chapter2.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Description: SwordOffer
 * time: 2019-11-19 15:59
 */
//给定二叉树,输出深度
public class No5501TreeDepth {
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
        No5501TreeDepth no5501TreeDepth = new No5501TreeDepth();
        System.out.println(no5501TreeDepth.getTreeDepth(node1));
    }

    private int getTreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
        return depth+1;
    }

}
