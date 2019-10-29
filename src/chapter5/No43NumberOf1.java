package chapter5;

import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-10-29 11:22
 */
//1-n整数中1出现的次数
public class No43NumberOf1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        No43NumberOf1 no43NumberOf1 = new No43NumberOf1();
        System.out.println(no43NumberOf1.getNumOf1(n));
        scanner.close();
    }

    private int getNumOf1(int n){
        if (n<1){
            return 0;
        }

        int high, low, curr, tmp, i=1;
        high = n;
        int number = 0;
        while (high != 0){
            high = n/(int) Math.pow(10, i);
            tmp = n%(int) Math.pow(10, i);
            curr = tmp/(int) Math.pow(10, i-1);
            low = tmp%(int) Math.pow(10, i-1);
            if (curr==1){
                number += high * (int) Math.pow(10, i-1)+low+1;
            }else if (curr<1){
                number += high * (int) Math.pow(10, i-1);
            }else {
                number += (high+1) * (int) Math.pow(10, i-1);
            }
            i++;
        }
        return number;
    }
}
