package chapter2;

import java.util.Scanner;

// 输入二叉树的前序遍历和中序遍历的结果，重建该二叉树
public class No7ConstructBinaryTree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pre = sc.nextLine();
        String mid = sc.nextLine();
        
        No7ConstructBinaryTree new7 = new No7ConstructBinaryTree();
        int[] preInt = new7.str2int(pre.split(","));
        int[] midInt = new7.str2int(mid.split(","));
        
        No7ConstructBinaryTree n7 = new No7ConstructBinaryTree();
        TreeNode tree = n7.creatNode(preInt, midInt);
        
        System.out.println(tree.val);
        sc.close();
    }
    
    public TreeNode creatNode(int[] preInt, int[] midInt){
        if(preInt.length != midInt.length){
            return null;
        }
        
        if(preInt.length == 0){
            return null;
        }
        
        int rt = preInt[0];
        TreeNode tNode = new TreeNode(rt);
        
        if(preInt.length == 1){
            return tNode;
        }
        
        for(int i=0; i<midInt.length; i++){
            if(midInt[i] == rt){                
                int[] preLeftArr = new int[i];
                int[] preRightArr = new int[midInt.length - i - 1];
                
                int[] midLeftArr = new int[i];
                int[] midRightArr = new int[midInt.length - i - 1];
                
//                左子树
                for(int m=0; m<i; m++){
                    preLeftArr[m] = preInt[m+1];
                    midLeftArr[m] = midInt[m+1];
                }
//                右子树
                for(int n=i+1; n<midInt.length; n++){
                    preRightArr[n-i-1] = preInt[n];
                    midRightArr[n-i-1] = midInt[n];
                }
//                如果要添加父节点，则
//                TreeNode leftNode = creatNode(preLeftArr,midLeftArr);
//                leftNode.father = tNode;
                tNode.left = creatNode(preLeftArr,midLeftArr);
                tNode.right = creatNode(preRightArr, midRightArr);
                break;
            }
        }
        return tNode;
    }
    
    public int[] str2int(String[] str){
        int[] arrInt = new int[str.length];
        
        for(int i=0; i<str.length; i++){
            arrInt[i] = Integer.parseInt(str[i]);
        }
        
        return arrInt;
    }
    
}
