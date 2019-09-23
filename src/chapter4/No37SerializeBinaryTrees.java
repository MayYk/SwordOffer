package chapter4;

import chapter2.TreeNode;

/**
 * Description: SwordOffer
 * time: 2019-09-21 17:49
 */
// 序列化和反序列化二叉树
public class No37SerializeBinaryTrees {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        No37SerializeBinaryTrees no37SerializeBinaryTrees = new No37SerializeBinaryTrees();
        String string = no37SerializeBinaryTrees.serialize(node1);
        System.out.println(string);
    }

//    序列化字符串
    private String serialize(TreeNode node){
        StringBuffer stringBuffer = new StringBuffer();
        if(node == null){
            stringBuffer.append("$");
            return stringBuffer.toString();
        }
        serializeNext(node, stringBuffer);
        stringBuffer.deleteCharAt(stringBuffer.indexOf(","));
        return stringBuffer.toString();
    }
    private StringBuffer serializeNext(TreeNode node, StringBuffer stringBuffer){
        if(node == null){
            stringBuffer.append(",$");
            return stringBuffer;
        }else {
            stringBuffer.append("," + node.val);
        }

        serializeNext(node.left, stringBuffer);
        serializeNext(node.right, stringBuffer);

        return stringBuffer;
    }

    private TreeNode Deserialize(String string){
        if (string == null || string.length() == 0){
            return null;
        }

        String[] strings = string.split(",");
        return DeserializeNext(strings);
    }

    private int index = -1;
    private TreeNode DeserializeNext(String[] strings){
        index++;
        TreeNode node = null;

        if (index < strings.length && !"$".equals(strings[index])){
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = DeserializeNext(strings);
            node.right = DeserializeNext(strings);
        }

        return node;
    }
}
