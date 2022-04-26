package medium.tree;


public class BinarySearchTree {
    /**
     * 96.不同的二叉搜索树 https://leetcode-cn.com/problems/unique-binary-search-trees/
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * 约定G(n)为n个节点组成的二叉搜索树数量，f(m)为以m为根节点的二叉搜索树数量
     *  则，G(n) = f(1) + f(2) + f(3) +...+ f(n);
     *  同时 f(m) = G(m-1) * G(n-m)
     *  两个公式合并 得到 G(n) = G(0)*G(n-1) + G(1)*G(n-2) +...+ G(n-1)*G(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
