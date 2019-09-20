package chapter4;

import chapter2.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: SwordOffer
 * time: 2019-09-11 21:29
 */

//不分行从上到下打印二叉树
//    主要考察了树和队列
public class No3201PrintTreeFromTopToBottom {
    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);

        node8.left = node6;
        node8.right = node10;

        node6.left = node5;
        node6.right = node7;

        node10.left = node9;
        node10.right = node11;
        No3201PrintTreeFromTopToBottom no32PrintTreeFromTopToBottom = new No3201PrintTreeFromTopToBottom();
        no32PrintTreeFromTopToBottom.printTree(node8);
    }

//    将树的节点加入队列，输出树直到队列为空
    private void printTree(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while (queue.size() != 0){
            head = queue.poll();
            System.out.println(head.val);

            if (head.left != null){
                queue.add(head.left);
            }

            if (head.right != null){
                queue.add(head.right);
            }
        }
    }
}
