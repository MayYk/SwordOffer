package chapter2;

import java.util.Stack;

//用两个栈实现队列
public class No9QueueWithTwoStacks {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    
    public void push(int ele){
        st1.push(ele);
    }
    
    public int pop(){
        if(st2.isEmpty()){
            if(st1.isEmpty()){
                return -1;
            }
            
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
}
