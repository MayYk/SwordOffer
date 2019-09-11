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
        TreeNode first8 = new TreeNode(8);
        TreeNode first6 = new TreeNode(6);
        TreeNode first5 = new TreeNode(5);
        TreeNode first7 = new TreeNode(7);
        TreeNode first10 = new TreeNode(10);
        TreeNode first9 = new TreeNode(9);
        TreeNode first11 = new TreeNode(11);

        first8.left = first6;
        first8.right = first10;

        first6.left = first5;
        first6.right = first7;

        first10.left = first9;
        first10.right = first11;
        No3201PrintTreeFromTopToBottom no32PrintTreeFromTopToBottom = new No3201PrintTreeFromTopToBottom();
        no32PrintTreeFromTopToBottom.printTree(first8);
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
