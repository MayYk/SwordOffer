package chapter2;

import java.util.Arrays;
import java.util.Scanner;

//把一个数组最开始的若干个元素搬到数组的末尾，称为数组的旋转。
//输入一个递增排序的一个旋转，输出旋转数组的最小元素
public class No11MinNumberInRotatedArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arrStr = line.split(",");
        int[] arrInt = new int[arrStr.length];
        for(int i=0; i<arrStr.length; i++){
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }
        No11MinNumberInRotatedArray n11 = new No11MinNumberInRotatedArray();
//        递归
        System.out.println(n11.binaryFind(arrInt));
        sc.close();
    }
//    抄的
    public int loopBinaryFind(int[] arrInt){
        if(arrInt == null || arrInt.length == 0){
            return 0;
        }
        
        int p = 0;
//        防止非逆序，不进while循环，可以直接输出
        int mid = p;
        int q = arrInt.length - 1;
        while (arrInt[p] >= arrInt[q]) {
            if(q-p==1){
                mid=q;
                break;
            }
            
            mid = p + ((q-p) >> 1);
//            p,mid,q三个下标指向的数字相等
            if (arrInt[p] == arrInt[q] && arrInt[mid] == arrInt[p]) {
                mid = getMinIndex(arrInt, p, q);
                break;
            }
            
            if(arrInt[mid] >= arrInt[p]){
                p = mid;
            }else if(arrInt[mid]<=arrInt[p]){
                mid = q;
            }       
        }
        return arrInt[mid];
    }
    
    private int getMinIndex(int[] array, int p, int q) {
        int minIndex = p;
        for (int i = p + 1; i <= q; ++i) {
            minIndex = array[i] < array[minIndex] ? i : minIndex;
        }
        return minIndex;
    }
    
//    递归(自己实现的)
    public int binaryFind(int[] arrInt){
        int ret = 0;
        if(arrInt.length > 0){
            ret = arrInt[0];
        } 
        int mid = arrInt.length/2;
        if(arrInt.length==1){
            return ret;
        }
        if(arrInt.length==2){
            return arrInt[0]>arrInt[1]? arrInt[1]:arrInt[0];
        }
        if(arrInt[0]<arrInt[1]){
            return arrInt[0];
        }
        if(arrInt[mid]>=arrInt[0]){
            int[] find = Arrays.copyOfRange(arrInt, mid, arrInt.length);
            ret = binaryFind(find);
        }else {
            int[] find = Arrays.copyOfRange(arrInt, 0, mid+1);
            ret = binaryFind(find);
        }
        return ret;
    }    
}
