package chapter4;

import chapter2.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: SwordOffer
 * time: 2019-09-20 20:27
 */
public class No34PathWithSum {
    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node12 = new TreeNode(12);

        node10.left = node5;
        node10.right = node12;

        node5.left = node4;
        node5.right = node7;
        No34PathWithSum no34PathWithSum = new No34PathWithSum();
        List<TreeNode> list = new ArrayList<>();
        no34PathWithSum.getPathWithSum(node10, 0, 22, list);
    }

    private void getPathWithSum(TreeNode head, int cur, int sum, List<TreeNode> list){
        cur += head.val;
        list.add(head);
        if (head.left != null){
            getPathWithSum(head.left, cur, sum, list);
        }
        if (head.right != null){
            getPathWithSum(head.right, cur, sum, list);
        }
        if (head.left==null && head.right==null && cur == sum){
            for (TreeNode nd:list) {
                System.out.print(nd.val + " ");
            }

            System.out.println("\n");
        }

        if(list.size() > 0){
            cur -= head.val;
            list.remove(list.size() - 1 );
        }

    }
}
