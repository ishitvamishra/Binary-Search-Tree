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
    public void addList(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        addList(root.left, list);
        addList(root.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        
        addList(root1, list);
        addList(root2, list);
        Collections.sort(list);
        return list;
    }


}