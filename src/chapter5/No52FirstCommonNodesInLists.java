package chapter5;

import chapter2.ListNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Description: SwordOffer
 * time: 2019-11-18 17:15
 */
//输入两个链表，找出它们的第一个公共节点
public class No52FirstCommonNodesInLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        if (m<1 || n<1){
            return ;
        }
        int num1 = scanner.nextInt();
        ListNode list1 = new ListNode(num1);
        ListNode head1 = list1;
        while (--m > 0){
            int num2 = scanner.nextInt();
            list1.next = new ListNode(num2);
            list1 = list1.next;
        }

        ListNode list2 = new ListNode(scanner.nextInt());
        ListNode head2 = list2;
        while (--n > 0){
            list2.next = new ListNode(scanner.nextInt());
            list2 = list2.next;
        }
        scanner.close();

        No52FirstCommonNodesInLists no52FirstCommonNodesInLists = new No52FirstCommonNodesInLists();
        System.out.println(no52FirstCommonNodesInLists.findFirstCommonNode(head1, head2));
    }

//    Sol1：借助辅助栈
    private int findFirstCommonNode(ListNode list1, ListNode list2){
        if (list1 == null || list2 == null){
            return -1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (list1 != null){
            stack1.push(list1.val);
            list1 = list1.next;
        }

        while (list2 != null){
            stack2.push(list2.val);
            list2 = list2.next;
        }

        int cur = -1;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            if (num1 != num2){
                return cur;
            }
            cur = num1;
        }

        return cur;
    }
//    Sol2:先计算两个链表长度,然后从相同剩余长度开始遍历,找到最后一个不同节点的下一个节点,即为第一个共同节点.

}
