package chapter2;

import java.util.Scanner;

//m行n列方格，机器人从（0,0）开始移动，不能进入行、列坐标和大于k的格子
//如k=18，可以进入(35,37)
//不能进入（35,38）,求能到达多少个格子
public class No13RobotMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int k = sc.nextInt();
        No13RobotMove no13 = new No13RobotMove();
        System.out.println(no13.findMaxDis(rows, cols, k));
        sc.close();
    }
    
    public int findMaxDis(int rows, int cols, int k){
        if(rows<=0 || cols<=0 || k<=0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = getCount(rows, cols, k, 0, 0, visited);
        return count;
    }
    
    public int getCount(int rows, int cols, int k, int m, int n, boolean[][] visited){        
        if(m>=0 && m<rows && n>=0 && n<cols && !visited[m][n] && (int2sum(m) + int2sum(n) < k)){
            visited[m][n] = true;
            return 1 + getCount(rows, cols, k, m-1, n, visited)
                    + getCount(rows, cols, k, m, n-1, visited)
                    + getCount(rows, cols, k, m+1, n, visited)
                    + getCount(rows, cols, k, m, n+1, visited);
        }
        return 0;
    }
    
    public int int2sum(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
