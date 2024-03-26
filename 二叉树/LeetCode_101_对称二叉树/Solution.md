# 题目
给你一个二叉树的根节点 root ， 检查它是否轴对称。

 

示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false
 

提示：

树中节点数目在范围 [1, 1000] 内
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

    bool check(TreeNode *p, TreeNode *q){
        if(p == nullptr && q== nullptr){
            return true;
        }
        if(p == nullptr || q==nullptr){
            return false;
        }
        return p -> val == q -> val && check(p -> left , q -> right) && check(p -> right , q -> left);
    }

    bool isSymmetric(TreeNode* root) {
        return check(root,root);
    }
};
```
# 思路
1. 其实这也是判断两个树是不是结构相等，值相等，请参考LeetCode100，只不过，现在变成一棵树。

# 复杂度：
- 时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)。
- 空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)。
