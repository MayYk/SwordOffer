package chapter2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//第三题-找出数组中重复的数字
public class No3RepeatNuminArray {
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         if(n<=0){
             System.out.println(0);
         }
         
         int[] numArray = new int[n];
         for(int i=0; i<n; i++){
             int next = sc.nextInt();
             if(next<0 || next>n){
                 System.out.println(0);
                 break;
             }else {
                numArray[i] = next;
            }
         }
         No3RepeatNuminArray ss = new No3RepeatNuminArray();
         Set<Integer> setNum = ss.getRepeatNum(numArray);
         System.out.println(setNum.toString());
         sc.close();
    }
    
    public Set<Integer> getRepeatNum(int[] numArray){
        Set<Integer> setNum = new HashSet<Integer>();
        
        Map<Integer, Integer> mapNum = new HashMap<Integer,Integer>();
        
        for(int i=0; i<numArray.length; i++){
            if(mapNum.containsKey(numArray[i])){
                setNum.add(numArray[i]);
            }else {
                mapNum.put(numArray[i], 1);
            }
        }
        return setNum;
    }
    
}
