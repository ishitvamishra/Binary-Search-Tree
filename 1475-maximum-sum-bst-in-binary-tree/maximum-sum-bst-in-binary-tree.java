/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class NodeValue{
    int minNode, maxNode, maxSum;
    
    NodeValue(int minNode, int maxNode, int maxSum){
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSum = maxSum;
    }
}

class Solution {
    int maxSum = 0;
    public NodeValue helper(TreeNode root){
        if(root == null){
            return new NodeValue(
                Integer.MAX_VALUE, 
                Integer.MIN_VALUE, 
                0
            );
        }
        
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        
        if(left.maxNode < root.val && root.val < right.minNode){
            int curSum = left.maxSum+right.maxSum+root.val;
            maxSum = Math.max(maxSum, curSum);
            return new NodeValue(
                Math.min(left.minNode, root.val),
                Math.max(right.maxNode, root.val),
                curSum
            );
        }
        
        else return new NodeValue(
            Integer.MIN_VALUE, 
            Integer.MAX_VALUE, 
            Math.max(left.maxSum, right.maxSum));
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}