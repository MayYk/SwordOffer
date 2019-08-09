package chapter2;

import java.util.Scanner;

// 非递归实现Fibonacci数列
public class No10Fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        No10Fibonacci n10 = new No10Fibonacci();
        int sum = n10.Fibonacci(n);
        System.out.println(sum);
        sc.close();
    }
    
    public int Fibonacci(int n ){
        if(n<2){
            return n;
        }
        
        int first = 0;
        int second = 1;
        int sum = 0;
        
        for(int i=2; i<=n; i++){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
