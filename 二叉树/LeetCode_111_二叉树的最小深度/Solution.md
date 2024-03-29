# 题目


给定一个二叉树，找出其最小深度。


最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点
![image](https://github.com/17230592226/LeetCode/assets/57279736/047c4da4-86ad-4326-b876-007b13f1a96d)
输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
 

提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000

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

    
    int minDepth(TreeNode* root) {
        if(root == nullptr) return 0;
         //不是叶子结点的时候不能返回0，因此要控制走向时，不要让他们向着空结点方向走（之前写代码这里出错了）
        if(root -> right != nullptr && root -> left == nullptr){
            return minDepth(root -> right) + 1;
        }
        if(root -> left != nullptr && root -> right == nullptr){
            return minDepth(root -> left) + 1;
        }

        

        return min(minDepth(root -> left),minDepth(root -> right)) + 1;
    }

};
```
# 思路
这其实与树的高度是一样的，不过得分清楚情况。
1. 是叶子结点时，返回0。
2. 只有左结点和右结点时，向着不是空结点的方向行走。
3. 与树的深度一样，返回每个分支的+1树的最小深度。

# 复杂度
- 时间复杂度：O（n），最多把所有的结点遍历一遍。
- 空间复杂度：O（n）, 是树的高度，也就是最坏的情况下，是坏的情况下是成一竖列。
