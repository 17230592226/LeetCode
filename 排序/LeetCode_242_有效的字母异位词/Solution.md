# 题目
242. 有效的字母异位词
已解答
简单
相关标签
相关企业
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

 

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
 

提示:

1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母
 

进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

# 解法1：排序
```
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()){
            return false;
        }
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        return s == t;
    }
};
```
# 复杂度
- 时间复杂度：O(nlog⁡n)，其中 n 为 s 的长度。排序的时间复杂度为 O(nlog⁡n)，比较两个字符串是否相等时间复杂度为 O(n)，因此总体时间复杂度为 O(nlog⁡n+n)=O(nlog⁡n)。
- 空间复杂度：O(log⁡n)。排序需要 O(log⁡n) 的空间复杂度。注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此我们需要额外的 O(n) 的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：这依赖于语言的细节；
这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。

# 解法2：哈希
```
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()){
            return false;
        }
        vector<int> table(26,0);

      //  for(char ch : s) 这一行写成这个也是对的。
      // for(int i = 0;i < s.size();i++){ table[s[i] -'a']++; 这一行也是对的
        for(auto& ch:s){
            table[ch -'a']++;
        }
        for(auto& ch:t){
            table[ch - 'a']--;
            if(table[ch - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
};
```
- 时间复杂度：O(n)，其中 n 为 s 的长度。
- 空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。


