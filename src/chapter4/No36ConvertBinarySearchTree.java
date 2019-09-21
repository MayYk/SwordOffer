package chapter4;

import chapter2.TreeNode;

import java.util.Stack;

/**
 * Description: SwordOffer
 * time: 2019-09-20 21:21
 */
//二叉搜索树转为双向链表
public class No36ConvertBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node14 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;
        No36ConvertBinarySearchTree no36ConvertBinarySearchTree = new No36ConvertBinarySearchTree();
        no36ConvertBinarySearchTree.tree2list(node10);
    }

    private TreeNode tree2list(TreeNode head){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        TreeNode res = null;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre == null){
                    pre = cur;
                    res = pre;
                }else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }

}
