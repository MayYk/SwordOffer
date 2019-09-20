package chapter4;

import chapter2.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: SwordOffer
 * time: 2019-09-11 21:56
 */
//分行从上到下打印二叉树
public class No3202PrintTreesInLines {
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

        No3202PrintTreesInLines no3202PrintTreesInLines = new No3202PrintTreesInLines();
        no3202PrintTreesInLines.printLine(node8);
    }

    private void printLine(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int nextLevel = 0;
        int toPrint = 1;
        while (queue.size() != 0){
            head = queue.poll();
            toPrint--;
            System.out.print(head.val + " ");
            if (head.left != null){
                queue.add(head.left);
                nextLevel++;
            }

            if (head.right != null){
                queue.add(head.right);
                nextLevel++;
            }

            if (toPrint == 0){
                toPrint = nextLevel;
                nextLevel = 0;
                System.out.print("\n");
            }
        }


    }


}
