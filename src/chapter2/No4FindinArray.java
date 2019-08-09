package chapter2;

import java.util.Scanner;

//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列从上到下递增，输入二维数组和一个整数，判断是否包含
public class No4FindinArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        
        int[][]  arr = new int[row][column];
        for(int m=0; m<row; m++){
            for(int n=0; n<column; n++){
                arr[m][n] = sc.nextInt();
            }
        }
        int find = sc.nextInt();
        No4FindinArray findArr = new No4FindinArray();
        System.out.println(findArr.isContain(arr, row, column, find));
        sc.close();
    }
    
    public boolean isContain(int[][] arr, int row, int column, int find){
        int m = 0;
        int n = column-1;
        while(m<row && n>=0){
            if(arr[m][n]==find){
                return true;
            }else if (arr[m][n]>find) {
                n--;
            }else {
                m++;
            }
        }
        return false;
    }
}
