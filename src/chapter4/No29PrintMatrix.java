package chapter4;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.rowset.internal.Row;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-09-03 22:33
 */
//输入矩阵，顺时针输出打印
public class No29PrintMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[][] mat = new int[a][a];
        for (int m=0; m<a; m++){
            for (int n=0; n<a; n++){
                mat[m][n] = scanner.nextInt();
            }
        }
        No29PrintMatrix no29PrintMatrix = new No29PrintMatrix();
        no29PrintMatrix.printMat(mat);
        scanner.close();
    }

    private void printMat(int[][] mat){
        int start = 0;
        int col = mat[0].length;
        int row = mat.length;

        while (col > start*2 && row > start*2){
            printCircle(mat, col, row, start );
            start++;
        }
    }

    private void printCircle(int[][] mat, int col, int row, int start){
        int endX = col - 1 - start;
        int endY = row - 1 - start;

        for (int i=start; i<=endX; i++){
            System.out.println(mat[start][i]);
        }

        if(start < endY){
            for (int i= start+1; i<=endY; i++){
                System.out.println(mat[i][endX]);
            }
            if (start<endX && start<endY){
                for (int i= endX-1; i>=start; i--){
                    System.out.println(mat[endY][i]);
                }
            }
            if (start < endX && start < endY-1){
                for (int i= endY-1; i>=start+1; i--){
                    System.out.println(mat[i][start]);
                }
            }
        }
    }
}
