## 9. 回文数
已解答
简单
相关标签
相关企业
提示
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数
是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

例如，121 是回文，而 123 不是。
 

示例 1：

输入：x = 121
输出：true
示例 2：

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：

输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。

## 代码
### 解法1：
```
func isPalindrome(x int) bool {
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if x < 0 || (x % 10 == 0 && x != 0) {
        return false
    }
    t := x

    revertedNumber := 0
    for t > 0 {
        revertedNumber = revertedNumber * 10 + t % 10
        t /= 10
    }

    return x == revertedNumber 
}
```
### 
- 时间复杂度：O(n)。
- 空间复杂度：O(1)。我们只需要常数空间存放若干变量。

### 解法2：
```
func isPalindrome(x int) bool {
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if x < 0 || (x % 10 == 0 && x != 0) {
        return false
    }

    revertedNumber := 0
    for x > revertedNumber {
        revertedNumber = revertedNumber * 10 + x % 10
        x /= 10
    }

    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    return x == revertedNumber || x == revertedNumber / 10
}

```
### 
- 时间复杂度：O(logn)，我们会将输入除以 10，因此时间复杂度为 O(logn)。
- 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
### 解法3：
```
func isPalindrome(x int) bool {
	//转换成字符串
	str := strconv.Itoa(x)
	//记录末尾索引
	end := len(str) - 1
	
	for i := 0; i < len(str)/2; i++ {
		if str[i] !=str[end] {
			return false
		
		end--
	}
		
	return true
}

```
## 
- 时间复杂度：如果按照个数T来看,时间复杂度O(T)。
- 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
