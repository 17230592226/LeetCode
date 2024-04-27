# 题目
给定一个二叉树，判断它是否是 
平衡二叉树
输入：root = [3,9,20,null,null,15,7]
输出：true
![image](https://github.com/17230592226/LeetCode/assets/57279736/0393a610-ef7e-445b-874f-1740acb71b25)


输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
![image](https://github.com/17230592226/LeetCode/assets/57279736/5a83e775-d6fc-46e6-818a-bbfae9ee39a5)


示例 3：

输入：root = []
输出：true


# 方法1：自顶向下的递归
定义函数 height，用于计算二叉树中的任意一个节点 p 的高度：

![image](https://github.com/17230592226/LeetCode/assets/57279736/00de50cb-89d7-47ae-9b0b-98c84d4a411a)

有了计算节点高度的函数，即可判断二叉树是否平衡。</br>
具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点：</br>
首先计算左右子树的高度，如果左右子树的高度差是否不超过 1，再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。</br>
这是一个自顶向下的递归的过程。

​ 
p 是空节点
p 是非空节点

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

    int height(TreeNode* root) {
        if (root == nullptr) return 0;

        return max(height(root->left), height(root->right)) + 1;

    }

    bool isBalanced(TreeNode* root) {
        if(root == nullptr) return true;
        
        return abs(height(root -> left) - height(root -> right) ) <= 1 && isBalanced(root -> left) && isBalanced(root -> right);    
    }
};
```

# 复杂度分析
 
# go
```
func isBalanced(root *TreeNode) bool {
    if root ==nil{
        return true
    }
    return abs(height(root.Left)-height(root.Right))<=1 && isBalanced(root.Left) && isBalanced(root.Right)
}
func height(root *TreeNode)int{
    if root==nil{
        return 0
    }
    return max(height(root.Left),height(root.Right))+1
}
func abs(x int ) int{
    if x<0{
        x = x * -1
    }
    return x

}
```
