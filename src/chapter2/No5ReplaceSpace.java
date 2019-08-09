package chapter2;

import java.util.Scanner;

// 输入字符串，将其中的空格替换成 %20
public class No5ReplaceSpace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuffer line = new StringBuffer(sc.nextLine());
        int len = line.length();
        if(line==null || len==0){
            System.out.println(line.toString());
        }
        
        for(int i=0; i<len; i++){
            if(line.charAt(i) == ' '){
                line.append("  ");
            }
        }
        int p = len - 1;
        int q = line.length() - 1;
        while (p>0) {
            char ch = line.charAt(p--);
            if(ch == ' '){
                line.setCharAt(q--, '0');
                line.setCharAt(q--, '2');
                line.setCharAt(q--, '%');
            } else {
                line.setCharAt(q--, ch);
            }
        }
        System.out.println(line.toString());
        sc.close();
    }
}
