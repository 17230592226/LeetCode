![image](https://github.com/17230592226/LeetCode/assets/57279736/acbf8b8b-20ab-4e58-b82a-e54608bd575f)# 题目
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。
![image](https://github.com/17230592226/LeetCode/assets/57279736/8e4f565e-5344-412f-994f-0cdb55a6da21)

# go
## 代码
```
func longestCommonPrefix(strs []string) string {
    if len(strs) ==0{
        return ""
    }
    prefix:=strs[0]
    for i:=1;i<len(strs);i++{
        prefix= com(prefix,strs[i])
        if len(prefix) ==0{
            break
        }
    }
    return prefix
}
func com(s1 ,s2 string) string {
    length := min(len(s1),len(s2))
    index :=0
    for index <length && s1[index] == s2[index]{
        index++
    }
    return s1[:index]
}
```
## 复杂度
![image](https://github.com/17230592226/LeetCode/assets/57279736/ece005ad-3e8d-443e-b8bb-9f572878f779)
