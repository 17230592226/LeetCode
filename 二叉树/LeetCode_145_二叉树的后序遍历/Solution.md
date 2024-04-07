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
# 解法2： 迭代
```
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }

        stack<TreeNode *> stk;
        TreeNode *prev = nullptr;
        while (root != nullptr || !stk.empty()) {
            while (root != nullptr) {
                stk.emplace(root);
                root = root->left;
            }
            root = stk.top();
            stk.pop();
            //与中序相比，遍历和向右走的情况不相同，它是退回到根节点后继续再向右走，代码下面的不同
            
            //root->right == nullptr 是遇到叶结点时。
            //root->right == prev是（左右根）的右 - 根，回退到根结点时
            if (root->right == nullptr || root->right == prev) {
                res.emplace_back(root->val);
                prev = root;
                //这里设置root = nullptr;可以让下次的root变成本次root的根结点
                root = nullptr;
            } else {
                //除了上面的情况，就是向右结点继续走
                stk.emplace(root);
                root = root->right;
            }
        }
        return res;
    }
};
```
# 复杂度
- 时间复杂度：o(n);
- 空间复杂度：O(n);

# 解法3：Morris 遍历


![image](https://github.com/17230592226/LeetCode/assets/57279736/5412962a-8e01-446d-80e5-ff1ce1edcc64)

```
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
//与先序、中序、后续相比，他们的遍历就遍历的点不一样。
//这里是新加入的方法，这个代码调用这个方法就是让上图中标注的1，2，3，4进行遍历。
    void addPath(vector<int>& vec, TreeNode* node) {
        int count = 0;
        while (node != nullptr) {
            ++count;
            vec.emplace_back(node->val);
            node = node->right;
        }
        reverse(vec.end() - count, vec.end());
    }

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        
        TreeNode *p = root, *pre = nullptr;

        while (root != nullptr) {
            if (root->left != nullptr) {
                pre = root->left;
                if (pre != nullptr) {
                    while (pre->right != nullptr && pre->right != root) {
                        pre = pre->right;
                    }
                    if (pre->right == nullptr) {
                        pre->right = root;
                        root = root->left;
                        continue;
                    } else {
                        pre->right = nullptr;
                        //这里与中序遍历不同，多了addPath(res, root->left);，少了一个res.push_back(root -> val)。
                        addPath(res, root->left);
                        root = root->right;
                    }
                }
            }
            else{
                 root = root->right;
            }
           
        }
        //这里与中序遍历不同，多了 addPath(res, p);，这是图中标注4，最后一次遍历翻转，从root开始遍历反转。这里的root就是p
        addPath(res, p);
        return res;
    }
};

```
# 复杂度
- 时间复杂度：o(n);
- 空间复杂度：O(1);
