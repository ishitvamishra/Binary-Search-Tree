// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class NodeValue{
    public int minNode, maxNode, maxSize;
    
    NodeValue(int minNode, int maxNode, int maxSize){
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
    }
}

class Solution {
    
    public NodeValue helper(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        
        if(left.maxNode < root.data && root.data < right.minNode){
            return new NodeValue(Math.min(left.minNode, root.data), Math.max(right.maxNode, root.data), left.maxSize+right.maxSize+1);
        }
        
        else return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    // Return the size of the largest sub-tree which is also a BST
    public int largestBst(Node root) {
        // Write your code here
        return helper(root).maxSize;
        
    }
}