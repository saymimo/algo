package leetcode;

import data_struct.TreeNode;

public class Easy235LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while((root.val - p.val) * (root.val - q.val) > 0){
            // 此时，p和q在同一侧，置换root到该侧
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}
