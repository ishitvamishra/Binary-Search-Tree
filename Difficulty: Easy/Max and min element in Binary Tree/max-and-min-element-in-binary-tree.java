/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    static int min, max;

public static void inorder(Node root) {
    if (root == null) return;

    min = Math.min(min, root.data);
    max = Math.max(max, root.data);

    inorder(root.left);
    inorder(root.right);
}

public static int findMin(Node root) {
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    inorder(root);
    return min;
}

public static int findMax(Node root) {
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    inorder(root);
    return max;
}
}