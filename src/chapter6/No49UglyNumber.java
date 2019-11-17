package chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-17 16:28
 */
public class No49UglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        No49UglyNumber no49UglyNumber = new No49UglyNumber();
        System.out.println(no49UglyNumber.getUglyNum(index));
        scanner.close();
    }

//    Sol1:暴力
    private boolean isUgly(int num){
        while (num%2==0){
            num /= 2;
        }
        while (num%3==0){
            num /= 3;
        }
        while (num%5==0){
            num /= 5;
        }
        return num == 1;
    }

    private int UglyNum(int index){
        if (index <= 0){
            return 0;
        }

        int num=0;
        int count=0;
        while (count<index){
            num++;
            if (isUgly(num)){
                count++;
            }
        }
        return num;
    }

//    Sol2：空间换时间
    private int getUglyNum(int index){
        if (index < 0){
            return 0;
        }

        List<Integer> reList = new ArrayList<>();

        reList.add(1);
//        表示位置
        int i2=0, i3=0, i5=0;
        while (reList.size()<index){
//            所有的丑数乘以2，3，5，都是丑数，所以从已知丑数中乘以2，3，5，选择最小的加入。
            int m2 = reList.get(i2)*2;
            int m3 = reList.get(i3)*3;
            int m5 = reList.get(i5)*5;

            int min = Math.min(m2, Math.min(m3,m5));

            if (m2==min){
                i2++;
            }
            if(m3==min){
                i3++;
            }
            if (m5 == min) {
                i5++;
            }
            reList.add(min);

        }
        return reList.get(reList.size()-1);
    }


}
