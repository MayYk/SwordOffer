package chapter3;

import java.util.Scanner;

public class No16Power {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int exp = scanner.nextInt();
        No16Power no16 = new No16Power();
//        System.out.println(no16.power(base, exp));
        System.out.println(no16.recom(base, exp));
        scanner.close();
    }
    
    public double recom(int base, int exp){
        double result = 1.0;
        int n = Math.abs(exp);
        for(int i=0; i<n; ++i){
            result *= base;
        }
        return exp<0?1.0/result:result;
    }
    
    public double power(int base, int exp){
        int result = 1;
        if(exp==0){
            return result;
        }
        
        if(exp>0){
            for(int i=0;i<exp;i++){
                result *= base;
            }
            return result;
        }
        
        if(exp<0){
            int ex = 0-exp;
            for(int i=0;i<ex;i++){
                result *= base;
            }
            return 1.0/result;
        }
        return 0;
    }
    
    
    
}
