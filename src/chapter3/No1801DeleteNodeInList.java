package chapter3;

import java.util.Scanner;

import chapter2.ListNode;

//给定单链表头指针和节点指针，定义函数在O(1)时间内删除该节点
public class No1801DeleteNodeInList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==0){
            scanner.close();
            return;
        }
        
        ListNode ln = new ListNode(scanner.nextInt());
        ListNode head = ln;
        while (--n > 0) {
            ln.next = new ListNode(scanner.nextInt());
            ln = ln.next;
        }

        int rm = 1;
        ListNode toDel = head;
        while (--rm >= 0) {
            toDel = toDel.next;
        }
        scanner.close();
        
        No1801DeleteNodeInList no18 = new No1801DeleteNodeInList();
        no18.delNode(head, toDel);
        head.toString();
    }
    
    private void delNode(ListNode head, ListNode toDel){
        if (toDel.next != null) {
            toDel.val = toDel.next.val;
            toDel.next = toDel.next.next;
        }else if (head == toDel) {
            head = null;
        }else {
            ListNode p = head;
            while(p.next != toDel){
                p = p.next;
            }
            p.next = null;
        }
    }
}
