package leetcode;

import data_struct.TreeNode;

public class Easy112HasPathSum {
    /**
     * 112. 路径总和 https://leetcode.cn/problems/path-sum/
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
