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
    //注意：相对于前序遍历，程序的编写的顺序值得注意。
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

# 复杂度
![image](https://github.com/17230592226/LeetCode/assets/57279736/34525875-32f3-48b1-9a6a-69bd6a9c714c)


# 解法2： 广度优先
```
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        if (root == nullptr) {
            return paths;
        }
        queue<TreeNode*> node_queue;
        queue<string> path_queue;

        node_queue.push(root);
        path_queue.push(to_string(root->val));

        while (!node_queue.empty()) {
            TreeNode* node = node_queue.front(); 
            string path = path_queue.front();
            node_queue.pop();
            path_queue.pop();

            if (node->left == nullptr && node->right == nullptr) {
                paths.push_back(path);
            } else {
                if (node->left != nullptr) {
                    node_queue.push(node->left);
                    path_queue.push(path + "->" + to_string(node->left->val));
                }

                if (node->right != nullptr) {
                    node_queue.push(node->right);
                    path_queue.push(path + "->" + to_string(node->right->val));
                }
            }
        }
        return paths;
    }
};
```
# 复杂度

![image](https://github.com/17230592226/LeetCode/assets/57279736/cc08df80-29ad-4a34-9adf-9ecd5207eda7)
