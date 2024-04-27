# 题目
给你一个二叉树的根节点 root ， 检查它是否轴对称。

 

示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false
 

提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100

# 解法1：递归
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

    bool check(TreeNode *p, TreeNode *q){
        if(p == nullptr && q== nullptr){
            return true;
        }
        if(p == nullptr || q==nullptr){
            return false;
        }
        return p -> val == q -> val && check(p -> left , q -> right) && check(p -> right , q -> left);
    }

    bool isSymmetric(TreeNode* root) {
        return check(root,root);
    }
};
```
## 思路
1. 其实这也是判断两个树是不是结构相等，值相等，请参考LeetCode100，只不过，现在变成一棵树。

## 复杂度：
- 时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)。
- 空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)。

# 解法2：迭代
## 代码
```
class Solution {
public:

    bool check(TreeNode *p, TreeNode *q){
        queue<TreeNode*> queue;
        queue.push(p);
        queue.push(q);

        while(!queue.empty()){
            p = queue.front();queue.pop();
            q = queue.front();queue.pop();
            
            if(p == nullptr && q == nullptr){
                continue;
            }
            if(p == nullptr || q == nullptr){
                return false;
            }
            if(p -> val != q -> val){
                return false;
            }
            queue.push(p -> left);
            queue.push(q -> right);

            queue.push(p -> right);
            queue.push(q -> left);

        }
        return true;
    }

    bool isSymmetric(TreeNode* root) {
        return check(root,root);
    }
};
```
## 思想：
没啥可说的，跟LeetCode100一样，现在只不过变成一个树。
## 复杂度
- 时间复杂度：O(n)，同「方法一」。
- 空间复杂度：这里需要用一个队列来维护节点，每个节点最多进队一次，出队一次，队列中最多不会超过 n 个点，故渐进空间复杂度为 O(n)。

# go
## 递归
```
  /**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool {
	return check(root, root)
}
func check(p, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	return p.Val == q.Val && check(p.Left, q.Right) && check(p.Right, q.Left)
}
```
