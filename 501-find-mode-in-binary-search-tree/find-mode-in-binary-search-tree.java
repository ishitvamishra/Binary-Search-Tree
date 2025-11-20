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
class Solution {
    private Integer prev = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> modesList;

    public int[] findMode(TreeNode root) {
        
        prev = null; count = 0; maxCount = 0;
        inorder(root, false);

        
        prev = null; count = 0;
        modesList = new ArrayList<>();
        inorder(root, true);

        
        int[] res = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) res[i] = modesList.get(i);
        return res;
    }

    
    private void inorder(TreeNode node, boolean collect) {
        if (node == null) return;
        inorder(node.left, collect);
        handleValue(node.val, collect);
        inorder(node.right, collect);
    }

    private void handleValue(int val, boolean collect) {
        if (prev == null || val != prev) {
            
            prev = val;
            count = 1;
        } else {
            
            count++;
        }

        if (!collect) {
            
            if (count > maxCount) maxCount = count;
        } else {
            
            if (count > maxCount) {
                
                modesList.clear();
                modesList.add(val);
                maxCount = count;
            } else if (count == maxCount) {
                modesList.add(val);
            }
        }
    }
}