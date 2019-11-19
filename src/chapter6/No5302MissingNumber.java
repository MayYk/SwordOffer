package chapter6;

import com.sun.deploy.panel.ITreeNode;
import sun.security.util.Length;

import java.util.Scanner;
import java.util.logging.Level;

/**
 * Description: SwordOffer
 * time: 2019-11-19 9:30
 */
//在范围 0 到 n-1 的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。
public class No5302MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = scanner.nextInt();
        }
        scanner.close();
        No5302MissingNumber no5302MissingNumber = new No5302MissingNumber();
        System.out.println(no5302MissingNumber.findMiss(arrs));
    }

    private int findMiss(int[] arrs){
        if (arrs == null || arrs.length == 0){
            return 0;
        }

        int n = arrs.length;
        int start = 0, end = n - 1;
        while (start <= end){
//            右移一位表示:原数值除以2
            int mid = start + ((end - start) >> 1);
            if (arrs[mid] != mid){
                if (mid == 0 || arrs[mid-1] == mid-1){
                    return mid;
                }
                end = mid - 1;
            }else {
                start = mid+1;
            }
        }
        return start == n ? n : -1;
    }
}
