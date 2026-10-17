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
    public boolean isSameTree(TreeNode p, TreeNode q) { // BFS
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(p);
        qu.offer(q);
        while (!qu.isEmpty()) {
            int qSize = qu.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode pNode = qu.poll();
                TreeNode qNode = qu.poll();
                if (pNode == null && qNode == null) {
                    continue;
                }
                if (pNode == null || qNode == null) {
                    return false;
                }
                if (pNode.val != qNode.val) {
                    return false;
                }
                qu.offer(pNode.left);
                qu.offer(qNode.left);
                qu.offer(pNode.right);
                qu.offer(qNode.right);
            }
        }
        return qu.isEmpty();
    }
}
