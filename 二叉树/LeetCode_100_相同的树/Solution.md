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

# 解法1 深度优先搜索
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
## 步骤
1. 相同的数，就意味着书的结构和值都相同，因此要检查数据的结构，如果P = null那么q也要 = null,如果p！= null，那么q != null。
2. 往下递归的时候，也就是最后要返回return 时，要用 &&，只要左右两边有一个为false，那么它的顶端就是false;
</br>
`高亮`
注意：有四种情况，分别是:
1. 两个根结点没有孩子
2. 第一个根结点有左孩子，第二个根结点没有孩子
3. 第一个根结点有右孩子，第二个根节点有左孩子
4. 两个根结点都有孩子

这个要满足结构相同，则要满足第一点和第四点，同时要第四点中的值相同，因此
- `p == nullptr && q == nullptr` 将第一点给包括了
- 之后的`p == nullptr || q == nullptr`将第二点和第四点包括
- 之后的`p -> val != q ->val`将值不相等给包括

## 复杂度
### 时间复杂度：
O(min⁡(m,n))，其中 m 和 n 分别是两个二叉树的节点数。</br>
对两个二叉树`同时`进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。</br>
空间复杂度：O(min⁡(m,n))，其中 mmm 和 nnn 分别是两个二叉树的节点数。空间复杂度取决于`递归调用的层数`，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。

# 解法2：广度优先搜索
## 代码
```
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        queue<TreeNode*> Q;
        Q.push(p);
        Q.push(q);

        while(!Q.empty()){
            p = Q.front(); Q.pop();
            q = Q.front(); Q.pop();

            if(p == nullptr && q == nullptr){
                continue;
            }
            if(p == nullptr || q == nullptr){
                return false;
            }
            if(p->val != q->val){
                return false;
            }

            Q.push(p -> left);
            Q.push(q -> left);

            Q.push(p -> right);
            Q.push(q -> right);
        }

        return true;
    }
};
```
## 思想
注意这里设计的很精妙，只使用了一个队列，即可完成判断
## 复杂度
### 时间复杂度：
- 时间复杂度：O(min⁡(m,n))，其中 m 和 n 分别是两个二叉树的节点数。对两个二叉树同时进行广度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
- 空间复杂度：O(min⁡(m,n))，其中 m 和 n 分别是两个二叉树的节点数。空间复杂度取决于队列中的元素个数，队列中的元素个数不会超过较小的二叉树的节点数。

# go
## 深度
```
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSameTree(p *TreeNode, q *TreeNode) bool {
    if p == nil && q==nil{
        return true
    }
    if p ==nil || q==nil{
        return false
    }
    if p.Val!=q.Val{
        return false
    }
    return isSameTree(p.Left,q.Left) && isSameTree(p.Right,q.Right)
}
```
