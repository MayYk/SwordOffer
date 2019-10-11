package chapter5;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * Description: SwordOffer
 * time: 2019-10-11 10:53
 */
//数组中出现次数超过一半的数字
public class No39MoreThanHalfNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,5,4,2};
        No39MoreThanHalfNumber no39MoreThanHalfNumber = new No39MoreThanHalfNumber();
        int result = no39MoreThanHalfNumber.getHalfNum(arr);
        System.out.println(result);
    }

    private int getHalfNum(int[] arr){
        int result = arr[0];
        int times = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == result){
                times++;
            }else{
                times--;
                if (times==0){
                    result = arr[i];
                    times=1;
                }
            }
        }
        if (checkMoreThanHalf(arr, result)){
            return result;
        }

        return 0;
    }

    private boolean checkMoreThanHalf(int[] arr, int result){

        int times = 0;

        for (int num: arr) {
            if(num == result){
                times++;
            }
        }

        return times*2 > arr.length;
    }

}
