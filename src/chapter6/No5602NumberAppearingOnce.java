package chapter6;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-19 19:12
 */
//找出数组中唯一只出现一次的数字,除了一个数字出现一次外,其他数字都出现了三次
//按位相加,出现三次的数字,该位相加能被3整除
public class No5602NumberAppearingOnce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrs = new int[n];
        for (int i=0; i<n; i++){
            arrs[i] = scanner.nextInt();
        }
        scanner.close();
        No5602NumberAppearingOnce no5602NumberAppearingOnce = new No5602NumberAppearingOnce();
        System.out.println(no5602NumberAppearingOnce.findNumAppearingOnce(arrs));
    }

    private int findNumAppearingOnce(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] bits = new int[32];
        int n = nums.length;
        for (int val: nums){
            for (int j=0; j<32; j++){
                bits[j] += (val&1);
                val = val>>1;
            }
        }

        int res=0;
        for (int i=0; i<32; i++){
            if (bits[i] % 3 != 0){
                res += Math.pow(2,i);
            }
        }
        return res;
    }
}
