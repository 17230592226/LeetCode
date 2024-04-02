# 题解
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

# 解法1：深度优先
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

    void bianli(TreeNode* root,vector<int>& v){
        if(root == nullptr){
            return;
        }
        v.push_back(root -> val);
        bianli(root -> left,v);
        bianli(root -> right,v);
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> v;
        bianli(root,v);
        return v;
    }
};
# 复杂度
- 时间复杂度：遍历缩点O(n)
- 空间复杂度；所使用栈的大小，即最坏情况下为O(n)
```
