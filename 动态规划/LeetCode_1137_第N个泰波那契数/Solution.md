# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/06ecd3c0-175c-41b1-b766-f63b01b37e5b)

# 代码
## go
```
func tribonacci(n int) int {
	if n < 2 {
		return n
	}
	if n == 2 {
		return 1
	}
//从f(i=3)开始，f(3) =f(0)+f(1)+f(2),因此q, r, s =f(0)，f(1)，f(2)
	p, q, r, s := 0, 0, 1, 1
	for i := 3; i <= n; i++ {
		p = q
		q = r
		r = s
		s = p + q + r
	}
	return s
}
```
## 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(1)
