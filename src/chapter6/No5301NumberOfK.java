package chapter6;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-18 22:05
 */
//数字在排序数组中出现的次数
//    输入:{1,2,3,3,3,3,4,5} 3
//    输出:4 (3出现的次数)
//    Sol:先二分找第一个数地址,再用二分找最后一个数地址,两个地址相减
public class No5301NumberOfK {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int find = scanner.nextInt();
        scanner.close();

        No5301NumberOfK no5301NumberOfK = new No5301NumberOfK();
        System.out.println(no5301NumberOfK.getNumOfK(arr, find));
    }

    private int getNumOfK(int[] arrs, int k){
        if (arrs == null || arrs.length == 0){
            return -1;
        }

        int start = 0, end = arrs.length-1;

        int first = getFistK(arrs, start, end, k);
        int last = getLastK(arrs, start, end, k);
        if (first>-1 && last>-1){
            return last-first+1;
        }
        return 0;
    }

    private int getFistK(int[] arrs, int start, int end, int k){
        if (start > end){
            return -1;
        }

        int m = start + ((end - start) >> 1);

        if (arrs[m] == k){
//            if (m == 0 || (m>0 && arrs[m-1] != k)){
//            能到第二个条件的时候,m一定大于0
            if (m == 0 || arrs[m-1] != k){
                return m;
            }else {
                end = m - 1;
            }
        }else {
            if (arrs[m] > k){
                end = m - 1;
            }else {
                start = m + 1;
            }
        }
        return getFistK(arrs, start, end, k);
    }

    private int getLastK(int[] arrs, int start, int end, int k){
        if (start > end){
            return -1;
        }

        int m = start + ((end-start) >> 1);
        if (arrs[m] == k){
            if (m == arrs.length-1 || (m<arrs.length-1 && arrs[m+1] != k)){
                return m;
            }else {
                start = m+1;
            }
        }else {
            if (arrs[m] > k){
                end = m - 1;
            }else {
                start = m + 1;
            }
        }
        return getLastK(arrs, start, end, k);
    }

}
