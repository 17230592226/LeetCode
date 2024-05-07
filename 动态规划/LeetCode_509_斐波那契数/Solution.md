# 题目
斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

![image](https://github.com/17230592226/LeetCode/assets/57279736/d20342c1-61c0-4579-871d-ac1c8445b089)

# 代码
## go
```
func fib(n int) int {
    if n<2{
        return n
    }
//f(2)=f(0)+f(1)，所以q,r分别是f(0)和f(1)
    p,q,r :=0,0,1
    for i:=2;i<=n;i++{
        p = q
        q = r
        r = p+q
    }
    return r
}
```
## 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(1)

