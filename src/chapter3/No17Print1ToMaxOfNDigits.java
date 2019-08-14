package chapter3;

import java.util.Scanner;

//打印从1到最大的n位数
public class No17Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        No17Print1ToMaxOfNDigits no17 = new No17Print1ToMaxOfNDigits();
        no17.countNum(n);
        scanner.close();
    }
    
    public void countNum(int n){
        if(n <= 0){
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[n+1];
        int cur = n;
        while(arr[0] != 1){
            if(arr[cur] != 10){
                arr[cur] += 1;
            }
            while(arr[cur] == 10) {
                arr[cur] = 0;
                --cur;
                arr[cur] += 1;
            }
            printNum(arr);
            cur = n;
        }
    }
    
    public void printNum(int[] arr){
        boolean flag = false;
        for(int i=1; i<arr.length;i++){
            if(arr[i] != 0){
                flag = true;
            }
            if(flag){
                System.out.print(arr[i]);
            }         
        }
        System.out.print("\n");
    }
    
    
    
}
