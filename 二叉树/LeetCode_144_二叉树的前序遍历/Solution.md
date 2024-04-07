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
```
# 复杂度
- 时间复杂度：遍历缩点O(n)
- 空间复杂度；所使用栈的大小，即最坏情况下为O(n)

# 解法2：迭代
```
class Solution {
public:


    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> stk;
        //加入root != nullptr 防止类似[1,null,2,3]作为输入的情况。
        while(root != nullptr || !stk.empty()){
            while(root != nullptr){
                //与中序遍历唯一不同的是res.push_back(root -> val);遍历的读取是在这里
                res.push_back(root -> val);
                stk.push(root);
                root = root -> left;
            }
            root = stk.top();
            //中序遍历的res.push_back(root -> val);是在这里。他么在栈中的走动顺序是一样的，只不过读取的顺序不一样。
            stk.pop(); 
            root = root -> right;
        }
        return res;
    }
    
};
```
# 复杂度
- 时间复杂度：遍历缩点O(n)
- 空间复杂度；所使用栈的大小，即最坏情况下为O(n)

# 解法3：Morris 遍历
```
class Solution {
public:


    vector<int> preorderTraversal(TreeNode* root) {
         vector<int> res;
        TreeNode *predecessor = nullptr;

        while (root != nullptr) {
            if (root->left != nullptr) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root->left;
                while (predecessor->right != nullptr && predecessor->right != root) {
                    predecessor = predecessor->right;
                }
                
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor->right == nullptr) {
                    predecessor->right = root;
                    //这里与先序遍历不同，多了res.push_back(root->val);
                    res.push_back(root->val);
                    root = root->left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    //这里与先序遍历不同，少了res.push_back(root->val);
                    predecessor->right = nullptr;
                    root = root->right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.push_back(root->val);
                root = root->right;
            }
        }
        return res;
           
    }
    
};
```
# 复杂度
- 时间复杂度：遍历缩点O(n)
- 空间复杂度；所使用栈的大小，即最坏情况下为O(1).只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间。
