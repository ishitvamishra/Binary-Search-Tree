/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] values = data.split(",");
        int[] idx = new int[1];

        return build(values, idx, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(String[] values, int[] idx, int low, int high) {
        if (idx[0] == values.length) return null;

        int val = Integer.parseInt(values[idx[0]]);

        if (val < low || val > high) return null;

        TreeNode root = new TreeNode(val);
        idx[0]++;

        root.left = build(values, idx, low, val);
        root.right = build(values, idx, val, high);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;