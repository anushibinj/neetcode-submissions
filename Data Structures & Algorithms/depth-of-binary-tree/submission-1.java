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

class Solution { // BFS
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxDepth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                TreeNode n = q.poll();
                if(n.left != null) {
                    q.offer(n.left);
                }
                if(n.right != null) {
                    q.offer(n.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
