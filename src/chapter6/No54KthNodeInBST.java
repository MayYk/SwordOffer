package chapter6;

import chapter2.TreeNode;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Description: SwordOffer
 * time: 2019-11-19 11:22
 */
//寻找二叉搜索树的第k大节点
//    Sol1:中序遍历
public class No54KthNodeInBST {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);

        node5.left = node3;
        node5.right = node7;

        node3.left = node2;
        node3.right = node4;

        node7.left = node6;
        node7.right = node8;

        No54KthNodeInBST no54KthNodeInBST = new No54KthNodeInBST();
        int k = 3;
        System.out.println(no54KthNodeInBST.KthNode(node5, k));
    }

    int count = 0;
    private TreeNode KthNode(TreeNode node, int k){
        if (node == null || k == 0){
            return null;
        }

//       左递归
        TreeNode retNode = KthNode(node.left, k);
        if (retNode != null){
            return retNode;
        }

        count++;
        if (count == k){
            return node;
        }

//      右递归
        retNode = KthNode(node.right, k);
        return retNode;
    }
}
