## 题目
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列

## 代码
```
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    dummy := &ListNode{}
    cur := dummy
    for list1 != nil && list2 != nil{
        if list1.Val < list2.Val{
            cur.Next = list1
            list1 = list1.Next
        } else{
            cur.Next = list2
            list2 = list2.Next
        }
        cur = cur.Next
    }
    if list1 !=nil{
        cur.Next = list1
    }
    if list2 != nil{
        cur.Next = list2
    }
    return dummy.Next
}
```
 ## 复杂度
 - 时间复杂度：O(n+m)，其中 n 为 list 1的长度，m 为 list 2的长度。
 - 空间复杂度：O(1)。仅用到若干额外变量。

## 代码
```
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
  if list1 == nil{
    return list2
  }
  if list2 == nil{
    return list1
  }
  if list1.Val < list2.Val{
    list1.Next = mergeTwoLists(list1.Next,list2)
    return list1
  }
  list2.Next = mergeTwoLists(list1,list2.Next)
  return list2
}
```
 ## 复杂度
 - 时间复杂度：O(n+m)，其中 n 为 list 1的长度，m 为 list 2的长度。
 - 空间复杂度：O(n+m)。递归需要 O(n+m) 的栈空间
