package chapter5;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-18 17:04
 */
//计算给定数组中的逆序对：如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
public class No51CountReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arrs = new int[n];
        for (int i=0; i<n; i++){
            arrs[i] = scanner.nextInt();
        }

        No51CountReverse no51CountReverse = new No51CountReverse();
        System.out.println(no51CountReverse.countReverse(arrs));

        scanner.close();
    }

    private int countReverse(int[] arrs){
        int count = 0;

        for (int i=0; i<arrs.length; i++){
            for (int j=i; j<arrs.length; j++){
                if (arrs[j]<arrs[i]){
                    count++;
                }
            }
        }
        return count;
    }

}
