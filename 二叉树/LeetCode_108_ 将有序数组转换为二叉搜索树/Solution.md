# 题目

给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。



输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
![image](https://github.com/17230592226/LeetCode/assets/57279736/cb4319f4-a997-48f2-a15d-9b2407688297)
![image](https://github.com/17230592226/LeetCode/assets/57279736/714385db-5f29-46a4-a862-6f925241fcfd)

输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树

![image](https://github.com/17230592226/LeetCode/assets/57279736/6d89293e-8d5b-44d9-9dae-99b878167112)

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列

# 思想

平衡二叉树（Balanced BinaryTree）又被称为AVL树。它具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。</br>

二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列。</br>

给定二叉搜索树的中序遍历，是否可以唯一地确定二叉搜索树？答案是否定的。如果没有要求二叉搜索树的高度平衡，则任何一个数字都可以作为二叉搜索树的根节点，因此可能的二叉搜索树有多个。
![image](https://github.com/17230592226/LeetCode/assets/57279736/3b07af1f-2a67-4aae-8007-758196a44861)

如果增加一个限制条件，即要求二叉搜索树的高度平衡，是否可以唯一地确定二叉搜索树？答案仍然是否定的。
![image](https://github.com/17230592226/LeetCode/assets/57279736/74a344ec-e370-4836-bc78-36d056be33d0)
直观地看，我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 1，可以使得树保持平衡。</br>
如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点，选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。
![image](https://github.com/17230592226/LeetCode/assets/57279736/1a1ee392-de58-4da4-b58f-460832ebe0b3)

确定平衡二叉搜索树的根节点之后，其余的数字分别位于平衡二叉搜索树的左子树和右子树中，左子树和右子树分别也是平衡二叉搜索树，因此可以通过递归的方式创建平衡二叉搜索树。

当然，这只是我们直观的想法，为什么这么建树一定能保证是「平衡」的呢？这里可以参考「1382. 将二叉搜索树变平衡」，这两道题的构造方法完全相同，这种方法是正确的，1382 题解中给出了这个方法的正确性证明：1382 官方题解，感兴趣的同学可以戳进去参考。

递归的基准情形是平衡二叉搜索树不包含任何数字，此时平衡二叉搜索树为空。

在给定中序遍历序列数组的情况下，每一个子树中的数字在数组中一定是连续的，因此可以通过数组下标范围确定子树包含的数字，下标范围记为 [left,right]。对于整个中序遍历序列，下标范围从 left=0 到 right=nums.length−1。当 left>right 时，平衡二叉搜索树为空。
</br>
以下三种方法中，方法一总是选择中间位置左边的数字作为根节点，方法二总是选择中间位置右边的数字作为根节点，方法三是方法一和方法二的结合，选择任意一个中间位置数字作为根节点。


# 方法
## 方式1：中序遍历，总是选择中间位置左边的数字作为根节点
选择中间位置左边的数字作为根节点，则根节点的下标为 mid=(left+right)/2\textit{mid}=(\textit{left}+\textit{right})/2mid=(left+right)/2，此处的除法为整数除法。
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

    TreeNode* help(vector<int>& nums , int left , int right){
        //left > right的想法可以参考数组中LeetCode35的二分查找
        if(left > right) return nullptr;

        
        int mid = (left + right) / 2;
        TreeNode* root = new TreeNode(nums[mid]);
        root -> left = help(nums, left, mid - 1);
        root -> right = help(nums, mid + 1, right);

        return root;
    }

    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return help(nums , 0 , nums.size() - 1);
    }
};
```
## 方法二：中序遍历，总是选择中间位置右边的数字作为根节点
选择中间位置右边的数字作为根节点，则根节点的下标为 mid=(left+right+1)/2，此处的除法为整数除法。
```
// 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;
```


## 方法三：中序遍历，选择任意一个中间位置数字作为根节点
选择任意一个中间位置数字作为根节点，则根节点的下标为 mid=(left+right)/2 和 mid=(left+right+1)/2 两者中随机选择一个，此处的除法为整数除法。

```
// 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand() % 2) / 2;
```

# 复杂度
- 时间复杂度：O(n)，其中 n 是数组的长度。每个数字只访问一次。
- 空间复杂度：O(log⁡n)，其中 nnn 是数组的长度。空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是 O(log⁡n)。

# go
```
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedArrayToBST(nums []int) *TreeNode {
    return create(nums,0,len(nums)-1)
}
func create(nums []int ,left int ,right int) *TreeNode{
    if left>right{
        return nil
    }
    
    mid:=(left+right)/2

    root:= &TreeNode{Val:nums[mid]}
    root.Left = create(nums,left,mid-1)
    root.Right = create(nums,mid+1,right)
    return root
}
```
