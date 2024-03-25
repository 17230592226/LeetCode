# 题目

104. 二叉树的最大深度

给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

 

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：3
示例 2：

输入：root = [1,null,2]
输出：2

提示：

树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100

# 代码
```
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root == nullptr){
            return 0 ;
        }
        return max(maxDepth(root -> left) , maxDepth(root -> right)) +1;
    }
};
```
# 步骤
1. 数的深度，就是从叶子结点累计加一，对根结点而言，需要比较左右两个子数哪一个的高度更高。

# 复杂度
- 时间复杂度：O(n)，其中 nnn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
- 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
