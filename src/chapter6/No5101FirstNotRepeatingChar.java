package chapter6;

import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

/**
 * Description: SwordOffer
 * time: 2019-11-17 16:52
 */
//第一个只出现一次的字符
public class No5101FirstNotRepeatingChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        No5101FirstNotRepeatingChar no5101FirstNotRepeatingChar = new No5101FirstNotRepeatingChar();
        System.out.println(no5101FirstNotRepeatingChar.getFirstNotRepeat(s));

        scanner.close();
    }

//Sol1：用数组
    private char getFirstNotRepeat(String s){
        if(s==null || s.length()==0){
            return 0;
        }

//        可以考虑直接拿map来做
        char[] chars = s.toCharArray();
        int[] ints = new int[26];

        for (int i=0; i< 26; i++){
            ints[i] = 0;
        }

        for (char j: chars){
            ints[j-'a'] += 1;
        }

        for (char m: chars){
            int n = ints[m-'a'];
            if (n==1){
                return m;
            }
        }

        return 0;
    }

//Sol2：直接用map计数
    private char getFirstNotRepeatWithMap(String str){
        if(str==null || str.length()==0){
            return 0;
        }

        char[] chars = str.toCharArray();
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i=0; i<str.length(); i++){
            characterMap.put(str.charAt(i), characterMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (characterMap.get(str.charAt(i)) == 1) {
                return chars[i];
            }
        }

        return 0;
    }

}
