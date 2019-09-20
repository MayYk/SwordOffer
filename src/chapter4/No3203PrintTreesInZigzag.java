package chapter4;

import chapter2.TreeNode;
import java.util.Stack;

/**
 * Description: SwordOffer
 * time: 2019-09-19 21:58
 */
//之字形打印二叉树
public class No3203PrintTreesInZigzag {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;
        node5.right = node11;

        node6.left = node12;
        node6.right = node13;

        node7.left = node14;
        node7.right = node15;

        No3203PrintTreesInZigzag no3203PrintTreesInLines = new No3203PrintTreesInZigzag();
        no3203PrintTreesInLines.printTreeInZig(node1);
    }

    private void printTreeInZig(TreeNode node1){
        int i = 1;
        Stack<TreeNode> curStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        curStack.push(node1);
//        网上做法：再加一个栈进行操作，最后判断原有的两个栈，把非空的赋给操作栈
        while (!curStack.isEmpty()){
            TreeNode node = curStack.pop();
            System.out.print(node.val + "\t");
            if (i % 2 != 0){
                if (node.left != null){
                    nextStack.push(node.left);
                }
                if(node.right != null){
                    nextStack.push(node.right);
                }
            }

            if (i % 2 == 0){
                if(node.right != null){
                    nextStack.push(node.right);
                }

                if (node.left != null){
                    nextStack.push(node.left);
                }
            }
            if (curStack.isEmpty()){
                i++;
                System.out.print("\n");
                curStack = (Stack) nextStack.clone();
                nextStack.clear();
            }
        }
    }

}
