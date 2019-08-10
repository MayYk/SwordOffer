package chapter2;

import java.util.Scanner;

//判断一个矩阵中是否包含存在一条包含某字符串所有字符的路径
//回溯类型的题，一般用递归做，
//遍历初始位置，然后逐个判断下一步

//测试输入
//abcesfcsadee
//3 4 4 bcced
public class No12StringPathInMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] matrix = sc.nextLine().toCharArray();
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int pathLength = sc.nextInt();
        char[] str = sc.nextLine().toCharArray();
        No12StringPathInMatrix no12 = new No12StringPathInMatrix();
        System.out.println(no12.hasPath(matrix, rows, cols, pathLength, str));
        sc.close();
    }
    
    public boolean hasPath(char[] matrix, int rows, int cols, int pathLength, char[] str){
        if(matrix == null || rows<1 || cols<1 || str ==null){
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
//        确定起始位置
        for(int m=0; m<rows; m++){
            for(int n=0; n<cols; n++){
                if(next(matrix, rows, cols, str, m, n, pathLength, visited)){
                    System.out.print("" + m + "," + n);
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean next(char[] matrix, int rows, int cols, char[] str, int m, int n, int pathLength, boolean[] visited){
        if(pathLength == str.length){
            return true;
        }
        
        boolean hasPath = false;
        
        if(m>=0 && m<rows && n>=0 && n<cols && matrix[m * cols + n] == str[pathLength] && !visited[m * cols + n]){
            pathLength++;
            visited[m*rows+n] = true;
            hasPath = next(matrix, rows, cols, str, m-1, n, pathLength, visited)
                    || next(matrix, rows, cols, str, m+1, n, pathLength, visited)
                    || next(matrix, rows, cols, str, m, n-1, pathLength, visited)
                    || next(matrix, rows, cols, str, m, n+1, pathLength, visited);
            if(!hasPath){
                pathLength --;
                visited[m*rows+n] = false;
            }
        }
        return hasPath;
    }
}
