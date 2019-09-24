package chapter4;

import java.util.*;

/**
 * Description: SwordOffer
 * time: 2019-09-23 22:17
 */
//输入一个字符串，打印出该字符串中字符的所有排列
public class No38StringPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        No38StringPermutation no38StringPermutation = new No38StringPermutation();
        ArrayList<String> toPrint = no38StringPermutation.strPrint(string);

        for (String string1: toPrint) {
            System.out.println(string1);
        }

        scanner.close();
    }

    private ArrayList<String> strPrint(String string){
        ArrayList<String> reList = new ArrayList<>();

        if(string == null || string.length() == 0){
            return reList;
        }

        char[] chars = string.toCharArray();
        strPrintHelper(chars, 0, reList);
        Collections.sort(reList);

        return reList;
    }


    private void strPrintHelper(char[] chars, int index, ArrayList<String> list){
        if (index == chars.length -1){
            list.add(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (!set.contains(chars[i])){
                set.add(chars[i]);
                swap(chars, i, index);
                strPrintHelper(chars, index+1, list);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
