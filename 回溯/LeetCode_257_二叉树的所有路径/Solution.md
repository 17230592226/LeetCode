给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。

 
示例 1：


输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
示例 2：

输入：root = [1]
输出：["1"]
 

提示：

树中节点的数目在范围 [1, 100] 内
-100 <= Node.val <= 100
# 解法1：深度，利用先序遍历，遍历过程中加入字符串进行回溯
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
    //注意：相对于前序遍历，程序的编写的顺序，
    void xianxu(TreeNode* root ,string s, vector<string>& v){
        if(root == nullptr) {
            return;
        }
        //加入整数的时候，to_string
        s += to_string(root -> val);
        if(root -> left == nullptr && root -> right == nullptr){
            v.push_back(s);
        } 
        s +="->";
        xianxu(root -> left,s,v);
        xianxu(root -> right,s,v);

    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> v;
        string s= "";
        xianxu(root,s,v);
        return v;
    }
};
```
# 时间复杂度
![image](https://github.com/17230592226/LeetCode/assets/57279736/e515ac3a-ea6f-48d4-a7b3-d14628ee1b3b)
