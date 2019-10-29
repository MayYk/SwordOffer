package chapter5;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-10-28 22:27
 */
//连续子数组的最大和
//    数组中的一个或连续多个证书组成一个子数组
public class No42GreatestSumOfSubarrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        No42GreatestSumOfSubarrays no42GreatestSumOfSubarrays = new No42GreatestSumOfSubarrays();
        System.out.println(no42GreatestSumOfSubarrays.getMaxSum(arr));
    }

    private int getMaxSum(int[] arr){
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int max = res[0];

        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] > 0 ? res[i - 1] + arr[i] : arr[i];
            max = Math.max(max, res[i]);
        }

        return max;
    }
}
