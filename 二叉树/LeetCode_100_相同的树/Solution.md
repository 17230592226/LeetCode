# 题目
100. 相同的树

给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

 

示例 1：


输入：p = [1,2,3], q = [1,2,3]
输出：true
示例 2：


输入：p = [1,2], q = [1,null,2]
输出：false
示例 3：


输入：p = [1,2,1], q = [1,1,2]
输出：false
 

提示：

两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104

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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if( p == nullptr && q == nullptr){
            return true;
        } 
        if( p == nullptr || q == nullptr){
            return false;
        }
        if(p -> val != q ->val){
            return false;
        }
        return isSameTree(p -> left , q -> left) && isSameTree(p -> right ,q -> right);
    }
};
```
# 步骤
1. 相同的数，就意味着书的结构和值都相同，因此要检查数据的结构，如果P = null那么q也要 = null,如果p！= null，那么q != null。
2. 往下递归的时候，也就是最后要返回return 时，要用 &&，只要左右两边有一个为false，那么它的顶端就是false;
# 复杂度
## 时间复杂度：
O(min⁡(m,n))，其中 m 和 n 分别是两个二叉树的节点数。</br>
对两个二叉树`同时`进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。</br>
空间复杂度：O(min⁡(m,n))，其中 mmm 和 nnn 分别是两个二叉树的节点数。空间复杂度取决于`递归调用的层数`，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
