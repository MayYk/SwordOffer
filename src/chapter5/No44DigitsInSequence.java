package chapter5;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Description: SwordOffer
 * time: 2019-10-29 19:56
 */
//数字序列中某一位的数字
public class No44DigitsInSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        No44DigitsInSequence no44DigitsInSequence = new No44DigitsInSequence();
        System.out.println(no44DigitsInSequence.getNum(n));

    }

    private int getNum(int n){
        if (n<0){
            return -1;
        }
        int i = 1;
        while(true){
            int num = countOfIntgers(i);
            if (n < i*num){
                break;
            }
            n -= num*i;
            ++i;
        }
        return digitAtIndex(i,n);
    }

    private int countOfIntgers(int digits){
        return digits==1?10:(int) (9 * Math.pow(10, digits-1));
    }

    private int digitAtIndex(int digits, int n){
        int beginNum = getBeginNum(digits);
        int val = beginNum + n/digits;
        int indexFromRight = digits - n%digits;
        for (int i = 1; i < indexFromRight; i++) {
            val /= 10;
        }
        return val%10;
    }

    private int getBeginNum(int digits){
        return digits == 1? 0: (int) Math.pow(10, digits - 1);
    }

}
