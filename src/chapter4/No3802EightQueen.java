package chapter4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Description: SwordOffer
 * time: 2019-10-09 15:34
 */
public class No3802EightQueen {
    public static void main(String[] args) {
        No3802EightQueen no3802EightQueen = new No3802EightQueen();
        String string = "01234567";
        LinkedList<String> quePo = no3802EightQueen.quePos(string);
        no3802EightQueen.judgeCount(quePo);
    }

    private LinkedList<String> quePos(String string){
        LinkedList<String> reList = new LinkedList<>();

        if (string == null || string.length() == 0) {
            return reList;
        }

        char[] chars = string.toCharArray();
        quePos(chars,0,reList);
        return reList;
    }

    private void quePos(char[] chars, int index, LinkedList<String> list){
        if (index == chars.length -1){
            list.add(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i=index; i<chars.length; i++){
            if(!set.contains(chars[i])){
                set.add(chars[i]);
                swap(chars,i,index);
                quePos(chars, index+1, list);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void judgeCount(LinkedList<String> linkedList){
        int count = 0;
        for (String string :linkedList) {
            boolean flag = true;
            char[] chars = string.toCharArray();
            for (int m = 0; m < chars.length; m++) {
                int cur1 = Integer.valueOf(string.substring(m,m+1));
                for (int n = m+1; n < chars.length; n++) {
                    int cur2 = Integer.valueOf(string.substring(n,n+1));
                    boolean isDia = ((m-n) == (cur1-cur2));
                    boolean isDia2 = ((n-m) == (cur1-cur2));
                    if ( isDia ||  isDia2 ){
                        flag = false;
                        break;
                    }
                }
                if (!flag){
                    break;
                }
            }
            if (flag){
                System.out.println(string);
                count++;
            }
        }
        System.out.println(count);
    }

}
