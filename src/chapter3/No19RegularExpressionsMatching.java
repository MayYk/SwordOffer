package chapter3;

import java.util.Scanner;

/**
 * Description: SwordOffer
 *
 * time:  2019-08-27 20:35
 */
//请实现一个函数用来匹配包括.和*的正则表达式。模式中的字符.表示任意一个字符，而*表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串aaa与模式a.a和ab*ac*a匹配，但是与aa.a和ab*a均不匹配。
public class No19RegularExpressionsMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().toCharArray();
        char[] pat = scanner.nextLine().toCharArray();
        No19RegularExpressionsMatching no19 = new No19RegularExpressionsMatching();
        System.out.println(no19.match(str, pat));
        scanner.close();
    }

    private boolean match(char[] str, char[] pat){
        if(str == null || pat == null){
            return false;
        }
        return match(str, 0, str.length, pat, 0, pat.length);
    }

    private boolean match(char[] str, int i, int len1,
                          char[] pattern, int j, int len2){
        if(i == len1 && j == len2){
            return true;
        }

        // "",".*"
        if(i != len1 && j == len2){
            return false;
        }

        if(j+1 < len2 && pattern[j+1] == '*'){
            if(i<len1 && (str[i] == pattern[j] || pattern[j] == '.')){
                return match(str, i, len1, pattern, j + 2, len2)
                        || match(str, i + 1, len1, pattern, j, len2)
                        || match(str, i + 1, len1, pattern,j + 2, len2);
            }
            // "",".*"
            return match(str, i, len1, pattern, j + 2, len2);
        }
        if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, len1, pattern, j + 1, len2);
        }
        return false;
    }
}
