package chapter5;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-17 11:39
 */
public class No48LongestSubstringWithoutDup {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        scanner.close();
    }

    private int getLongestSubstring(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        char[] chars = s.toCharArray();

//        标识每个字符上次出现的位置
        int[] ints = new int[26];
        for (int i=0; i<26; i++){
            ints[i] = -1;
        }
//        初始化第一个字符
        ints[chars[0]-'a'] = 0;
        int n = chars.length;

        int[] res = new int[n];
        res[0] = 1;
        int max = res[0];
        for (int i=1; i<n; i++){
            int index = ints[chars[i]-'a'];
            int d = i-index;

//            判断该字符和上次出现的位置计算对比
            res[i] = (index==-1 || d>res[i-1])? res[i-1]+1 : d;

            ints[chars[i]-'1']=i;
            max = Math.max(max, res[i-1]);
        }
        return max;
    }
}
