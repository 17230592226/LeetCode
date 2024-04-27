# 题目

104. 二叉树的最大深度

给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

 

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：3
示例 2：

输入：root = [1,null,2]
输出：2

提示：

树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100

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
    int maxDepth(TreeNode* root) {
        if(root == nullptr){
            return 0 ;
        }
        return max(maxDepth(root -> left) , maxDepth(root -> right)) +1;
    }
};
```
## 步骤
1. 数的深度，就是从叶子结点累计加一，对根结点而言，需要比较左右两个子数哪一个的高度更高。

## 复杂度
- 时间复杂度：O(n)，其中 nnn 为二叉树节点的个数。每个节点在递归中只被遍历一次。
- 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。

# 解法2 广度优先搜索
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
    int maxDepth(TreeNode* root) {
        if(root == nullptr) return 0;
        queue<TreeNode*> Q;
        Q.push(root);
        int ans = 0;
        while(!Q.empty()){ //注意这里出错了，这里不能写成，Q.empyt() != 0
            int size = Q.size();
            while(size > 0){
                TreeNode* node = Q.front(); //注意这里的front，不是栈里面的top
                Q.pop();
                if(node -> left != nullptr) Q.push(node -> left);
                if(node -> right != nullptr) Q.push(node -> right);
                size--;
            }
            ans++;
        }
        return ans;
    }
};
```
## 思路与算法
我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans。</br>
1. 判断根节点不存在的情况，定义队列Q，定义记录的整个层数ans，将根节点放入队列中
2. 判断Q是否为空，定义每一行的放入的队列的数目size
3. 最后将队列中的元素一行一行取出，并将左右结点放入队列中。


## 复杂度分析
- 时间复杂度：O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
- 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。
# go 
## 深度
```
func maxDepth(root *TreeNode) int {
if root == nil {
        return 0
    }
    return max(maxDepth(root.Left), maxDepth(root.Right)) + 1
}
```
