# 题目
给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
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

    void houxu(TreeNode* root , vector<int>& v){
        if(root == nullptr) return ;
        houxu(root -> left,v);
        houxu(root -> right,v);
        v.push_back(root -> val);
    }
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> v;
        houxu(root,v);
        return v;
    }
};
```
# 复杂度
- 时间复杂度：o(n);
- 空间复杂度：O(n);

