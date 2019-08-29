package chapter3;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-08-29 21:22
 */
//输入一个整数数组，调整数组中数字位置，使奇数位于数组的前半部分，偶数位于数组的后半部分
public class No21ReorderArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<=0){
            scanner.close();
            return;
        }
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        No21ReorderArray no21ReorderArray = new No21ReorderArray();
        int[] ss = no21ReorderArray.Reorder(arr);
        for (int i=0;i<n;i++){
            System.out.print(ss[i]);
        }
        scanner.close();
    }

    private int[] Reorder(int[] arr){
        int head = 0;
        int tail = arr.length-1;

        while (head < tail){
            while (arr[head] % 2 != 0 && head < tail){
                head++;
            }

            while (arr[tail] % 2 == 0 && head < tail){
                tail--;
            }
            if(head < tail){
                int tem = arr[head];
                arr[head] = arr[tail];
                arr[tail] = tem;
            }
        }
        return arr;
    }


    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        Integer[] bak = new Integer[array.length];
        Arrays.setAll(bak, i -> array[i]);
        Arrays.sort(bak, (x, y) -> (y & 1) - (x & 1));
        Arrays.setAll(array, i -> bak[i]);
    }
}
