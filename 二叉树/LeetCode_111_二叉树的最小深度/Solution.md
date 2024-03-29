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
# 解法1：深度优先搜索
## 代码
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
        //叶结点
        if(root == nullptr) return 0;
         //不是叶子结点的时候不能返回0，因此要控制走向时，不要让他们向着空结点方向走（之前写代码这里出错了）
        if(root -> right != nullptr && root -> left == nullptr){
            return minDepth(root -> right) + 1;
        }
        if(root -> left != nullptr && root -> right == nullptr){
            return minDepth(root -> left) + 1;
        }

        
        //有左结点和右结点时
        return min(minDepth(root -> left),minDepth(root -> right)) + 1;
    }

};
```
## 思路
这其实与树的高度是一样的，不过得分清楚情况。
1. 是叶子结点时，返回0。
2. 只有左结点和右结点时，向着不是空结点的方向行走。
3. 与树的深度一样，返回每个分支的+1树的最小深度。

## 复杂度
- 时间复杂度：O（n），最多把所有的结点遍历一遍。
- 空间复杂度：O（n）, 是树的高度，也就是最坏的情况下，是坏的情况下是成一竖列。平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。

# 广度优先搜索

## 代码
```
class Solution {
public:

    
    int minDepth(TreeNode* root) {
        if(root == nullptr) return 0;

        queue<TreeNode*> Q;
        Q.push(root);
        int ans = 1;
        while(!Q.empty()){
            int size = Q.size();
            while(size > 0){
                TreeNode* node = Q.front();Q.pop();
                if(node -> left != nullptr && node -> right == nullptr){
                    Q.push(node -> left);
                }else if(node -> right != nullptr && node -> left == nullptr){
                    Q.push(node -> right);
                }else if(node -> left != nullptr && node -> right != nullptr){
                    Q.push(node -> left);
                    Q.push(node -> right);
                }else{
                    return ans;
                }
                size--;
            }
            ans++;
        }
        return 0;
    }
};
```
## 思路
思路还是一样的，跟`树的高度`类似，我们求树的高度，然后当遇到`叶结点`的时候就是最小的深度。
分四种情况，
1. 无结点
2. 只有左结点
3. 只有右结点
4. 有左结点和右结点

# 复杂度
- 时间复杂度：O(n)，最多遍历整个结点
- 空间复杂度: O(n)，就是队列的空间大小，最多是n
