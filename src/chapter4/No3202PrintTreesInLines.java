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

        No3202PrintTreesInLines no3202PrintTreesInLines = new No3202PrintTreesInLines();
        no3202PrintTreesInLines.printLine(first8);
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
