package chapter3;

import chapter2.ListNode;

import javax.swing.*;
import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-08-30 19:36
 */
//   输入一个链表，输出该链表中倒数第k个节点，倒数从1开始技术，如6个节点，值一次是1，2，3，4，5，6，这个链表的倒数第三个节点为4
//  主要是考验鲁棒性
public class No22KthNodeFromEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ListNode listNode = new ListNode(scanner.nextInt());
        ListNode head = listNode;

        for (int i=0; i<n-1; i++){
            listNode.next = new ListNode(scanner.nextInt());
            listNode = listNode.next;
        }
        if(n==0 || k==0 || n<k){
            System.out.println("error");
            return;
        }
        No22KthNodeFromEnd no22 = new No22KthNodeFromEnd();
        System.out.println(no22.getKthNode(k, head));

        scanner.close();
    }

    private int getKthNode(int k, ListNode head){
        ListNode gkn = head;
        for (int i=0; i<k-1; i++){
            gkn = gkn.next;
        }
        while (gkn.next != null){
            head = head.next;
            gkn = gkn.next;
        }
        return head.val;
    }
}
