package chapter5;

import java.util.Scanner;

/**
 * Description: SwordOffer
 * time: 2019-11-01 22:35
 */
//礼物的最大价值
public class No47MaxValueOfGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] giftArr = new int[m][n];
        for(int i=0; i<m; i++){
            for (int j=0;j<n; j++){
                giftArr[i][j] = scanner.nextInt();
            }
        }
        No47MaxValueOfGifts no47MaxValueOfGifts = new No47MaxValueOfGifts();
        System.out.println(no47MaxValueOfGifts.getMaxVal(giftArr));
        scanner.close();
    }

    private int getMaxVal(int[][] grid){
        if (grid == null || grid.length ==0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];

//        边缘礼物和内部礼物的公式不同，所以分开判断
        for (int j=1; j<n; j++){
            res[0][j] = res[0][j-1] + grid[0][j];
        }

        for (int i=1; i<m; i++){
            res[i][0] = res[i-1][0] + grid[i][0];
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                res[i][j] = Math.max(res[i-1][j], res[i][j-1]) + grid[i][j];
            }
        }
        return res[m-1][n-1];
    }
}
