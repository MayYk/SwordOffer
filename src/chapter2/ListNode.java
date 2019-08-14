package chapter2;

public class ListNode {
    public int val;
    public ListNode next = null;
    
    public ListNode(){
        
    }
    
    public ListNode(int val) {
        // TODO Auto-generated constructor stub
        this.val = val;
    }
    
    public String toString(){
        System.out.println(val);
        while(next != null){
            System.out.println(next.val);
            next = next.next;
        }
        return "";
    }
    
}
