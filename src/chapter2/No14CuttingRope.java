package chapter2;

import java.util.Scanner;

//将长度为n的绳子,剪成m段,且m>1, n>1,求最大乘积
public class No14CuttingRope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        No14CuttingRope no14 = new No14CuttingRope();
        System.out.println(no14.maxProductCutting(n));
        sc.close();
    }
    
    public int maxProductCutting(int n){
        if(n<2){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        
        int[] products = new int[n+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        
        int max = 0;
        
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 0; j < i/2; j++) {
                int pro = products[j] * products[i-j];
                if(max<pro){
                    max = pro;
                }
                
                products[i] = max;
            }
        }
        
        max = products[n];
        return max;
    }
    
}
