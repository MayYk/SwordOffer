package chapter2;

import java.util.Scanner;
import java.util.Stack;

// 从尾到头打印链表
public class No6printListInReverseOrder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        int n = sc.nextInt();
        ListNode ln = new ListNode(sc.nextInt());
        ListNode head = ln;
        
        while(n-->1){
            head.next = new ListNode(sc.nextInt());
            head = head.next;
        }        
        
//      正序输出
//        ListNode end = ln;
//        System.out.println(end.val);
//        while(end.next != null){
//            end = end.next;
//            System.out.println(end.val);
//        }
        
//      倒序输出----stack
        Stack<Integer> stack = new Stack<Integer>();
        ListNode curr = ln;
        stack.push(curr.val);
        while(curr.next != null){
            curr = curr.next;
            stack.push(curr.val);
        }
        
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
        
        sc.close();
    }
}
