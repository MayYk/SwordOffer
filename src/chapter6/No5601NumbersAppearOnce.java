package chapter6;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-19 17:00
 */
//找出数组中只出现一次的两个数字
//    Sol:异或迭代,最后得到的数字,肯定不为0,二进制为1的那一位是不相同的那一位,可将所有数字按这一位是否为1,分成两个数组,然后各数组迭代找出那一个.
public class No5601NumbersAppearOnce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrs = new int[n];
        for (int i=0; i<n; i++){
            arrs[i] = scanner.nextInt();
        }
        scanner.close();

        No5601NumbersAppearOnce no5601NumbersAppearOnce = new No5601NumbersAppearOnce();
        int[] twoNum = no5601NumbersAppearOnce.findNumsApperOnce(arrs);
        for (int e: twoNum){
            System.out.println(e);
        }
    }

    private int[] findNumsApperOnce(int[] nums){
        if (nums == null || nums.length < 2){
            return nums;
        }

        int xorRes = 0;
        for (int e:nums){
            xorRes ^= e;
        }

        int[] res = new int[2];
        int index = indexOf1(xorRes);
        for (int e:nums){
            if(isBit1(e, index)){
                res[0] ^= e;
            }else {
                res[1] ^= e;
            }
        }
        return res;
    }

    private int indexOf1(int val){
        int index = 0;
        while ((val & 1)==0){
            val = val >> 1;
            ++index;
        }
        return index;
    }

    private boolean isBit1(int val, int index){
        val = val >> index;
        return (val & 1) == 1;
    }


}
