package chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-10-31 22:13
 */
//把数字翻译成字符串
//    利用dp
public class No46TranslateNumbersToStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        scanner.close();
    }

    private int countMaybe(String string){
        char[] chars = string.toCharArray();
        int n = chars.length;
        int count=0;
        int[] res = new int[n];
        res[0] = 1;
        res[1] = isInRange(chars[0], chars[1])? 2:1;
        for (int i=0; i<n; i++){
            res[i] = res[i-1]+(isInRange(chars[i-1], chars[i])? res[i-2]:0);
        }
        return res[n-1];
    }

    private boolean isInRange(char a, char b){
        int s = (a-'0') * 10 + (b-'0');
        return s>=10 && s<=25;
    }


}
