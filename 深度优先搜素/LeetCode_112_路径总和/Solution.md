# 题目
112. 路径总和
已解答
简单
相关标签
相关企业
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。
![image](https://github.com/17230592226/LeetCode/assets/57279736/8191eeef-3d39-4a7f-9b1e-00ba497da322)

# go代码
## 递归
```
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func hasPathSum(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}

	if root.Left == nil && root.Right == nil {
		return targetSum == root.Val
	}
	return hasPathSum(root.Left, targetSum-root.Val) ||
		hasPathSum(root.Right, targetSum-root.Val)
}
```
## 复杂度
- 时间复杂度：O(N),其中N是树的结点数。对每个节点访问一次。
- 空间复杂度：O(H),其中H是数的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，数呈链状，空间复杂度为O(N)。平均情况下数的高度与节点数的对数正相关，空间复杂度为O(logN)
