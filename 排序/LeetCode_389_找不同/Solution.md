# 题解
给定两个字符串 s 和 t ，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

 

示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
 

提示：

0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母

# 解1：哈希
```
class Solution {
public:
    char findTheDifference(string s, string t) {
        unordered_map<int,int> map;

        for(char s1 : s){
            map[s1 - 'a']++;
        }
        for(char t1 : t){
            map[t1 - 'a']--;
            if(map[t1 - 'a'] < 0){
                return t1;
            }
        }
        return -1;
    }
};
```
# 复杂度
- 时间复杂度：O(n)
- 空间复杂度：O(n)

# go语言
```
func findTheDifference(s string, t string) byte {
    map1:=map[int]int{}
    for _,v:=range s{
        map1[int(v-'a')]+=1
    }
    for _,v :=range t{
        map1[int(v-'a')]--
        if map1[int(v-'a')] < 0{
            return byte(v)
        }
    }
    return 'a'
    
}
```
- 注意for i := 0; ; i++ 中没有明确结束点，因此只在循环内进行返回就行，然而上面这个代码，需要额外的在for循环之外加入return 返回值
```
func findTheDifference(s, t string) byte {
    cnt := [26]int{}
    for _, ch := range s {
        cnt[ch-'a']++
    }
    for i := 0; ; i++ {
        ch := t[i]
        cnt[ch-'a']--
        if cnt[ch-'a'] < 0 {
            return ch
        }
    }
}

```
