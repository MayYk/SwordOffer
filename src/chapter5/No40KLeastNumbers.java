package chapter5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-10-11 11:23
 */
//最小的k个数
public class No40KLeastNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        No40KLeastNumbers no40KLeastNumbers = new No40KLeastNumbers();
        ArrayList<Integer> das = no40KLeastNumbers.getKth(arr, k);
        scanner.close();
    }

    private ArrayList<Integer> getKth(int[] arr, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < k || k < 1){
            return res;
        }

        int n = arr.length;
        int start = 0;
        int end = n-1;
        int index = partition(arr,start,end);
        while (index != k-1){
            if (index > k-1){
                end=index-1;
            }else{
                start = index+1;
            }
            index = partition(arr,start,end);
        }
        for (int i=0; i<k; ++i){
            res.add(arr[i]);
        }
        return res;
    }

    private int partition(int[] arr,int start, int end){
        int index = start-1;
        for (int i=start; i<end; ++i){
            if (arr[i] < arr[end]){
                swap(arr, i, ++index);
            }
        }
        ++index;
        swap(arr, index, end);
        return index;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
