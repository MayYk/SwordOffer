package chapter2;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(){
        this.val = 0;
        this.next = null;
    }

    public ListNode(int val) {
        // TODO Auto-generated constructor stub
        this.val = val;
    }

    public void addListNode(ListNode nextNode){
        this.next = nextNode;
    }

//    这里toString不要改变原有结构
//    如toString,改变了原有next指向
//    debug查看变量内容时,会调用toString方法,影响了原有结构
    @Override
    public String toString(){
//        System.out.println(val);
//        System.out.println("das");
//        while(next != null){
//            System.out.println(next.val);
//            next = next.next;
//        }
        return "" + val;
    }

}
