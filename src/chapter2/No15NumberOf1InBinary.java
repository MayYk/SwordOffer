package chapter2;

import java.util.Scanner;


//输入一个数，输出将其转为二进制后，数字中1的个数
public class No15NumberOf1InBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        No15NumberOf1InBinary no15 = new No15NumberOf1InBinary();
        int count = no15.baseMethod(m);
        
        
        System.out.println(count);
        
        sc.close();
    }

    public int baseMethod(int m){
        int count = 0;
        
        while(m != 0){
            if((m & 1) != 0){
                count++;
            }
        } 
        return count;
    }
    
    public int improveMethod(int m){
        int count = 0;
        
        while(m != 0){
            m = (m - 1 ) & m;
            ++count;
        } 
        return count;
    }
    
}
