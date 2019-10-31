package chapter5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-10-29 20:54
 */
//把数组排成最小的数
public class No45SortArrayForMinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        No45SortArrayForMinNumber no45SortArrayForMinNumber = new No45SortArrayForMinNumber();
        System.out.println(no45SortArrayForMinNumber.printMinNum(nums));
        scanner.close();
    }

    private String printMinNum(int[] nums){
        if(nums == null || nums.length == 0){
            return "0";
        }

        int n = nums.length;
        String[] strings = new String[n];
        for (int i=0; i<n; i++){
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder stringBuilder = new StringBuilder();
        for (String string:strings){
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }



}
