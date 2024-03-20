# 题目
94. 二叉树的中序遍历

给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

示例 1：

输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
 

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
 

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

# 代码
## 解1：递归
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

    void midTraverse(TreeNode* root , vector<int>& res){
        if(root == nullptr){
            return ;
        }
        midTraverse(root->left,res);
        res.push_back(root->val);
        midTraverse(root->right,res);
    }

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        midTraverse(root,res);
        return res;
    }
};
```
## 步骤
1. 定义向量res 和 递归方法
2. 判断是否达到末尾节点。否则就按左->根->右这样走。
## 复杂度
时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
</br>
空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n)的级别。



## 解2：迭代
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> stk;

        while(root != nullptr || !stk.empty()){
            while(root != nullptr){
                stk.push(root);
                root = root -> left;
            }
            root = stk.top();
            stk.pop();
            res.push_back(root -> val);
            root = root -> right;
        }
        return res;
    }
};
```
## 步骤
1. 定义向量和栈
2. 使用两层循环，第一层：只要栈不为空和当前节点也不是空节点就循环。左：第二层：只要左子树不为空就一直向左方向走，并压入栈。
3. 注意第二层循环结束时，root为nullptr，因此弹出栈顶赋值，并抛弃。
4. 中：将栈顶元素放入向量中。
5. 右：root指向右子树。

## 复杂度
时间复杂度：O(n)，其中 nnn 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
<br>
空间复杂度：O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。



   
