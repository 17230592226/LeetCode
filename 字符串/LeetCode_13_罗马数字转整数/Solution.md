# 题目
![image](https://github.com/17230592226/LeetCode/assets/57279736/fee00f8e-987d-4564-8971-c8e3a4b11be6)
![image](https://github.com/17230592226/LeetCode/assets/57279736/3269eac3-2bfe-45d1-8cdb-20624ee72299)

# 代码
```
class Solution {

private:
    unordered_map<char,int> map={
        {'I',1},
        {'V',5},
        {'X',10},
        {'L',50},
        {'C',100},
        {'D',500},
        {'M',1000},
    };
public:
    int romanToInt(string s) {
        int ans = 0;
        int n= s.length();
        for(int i =0;i<n;i++){
            int value = map[s[i]];
            if(i<n-1 && value <map[s[i+1]]){
                ans-=value;
            }else{
                ans+=value;
            }
        }
        return ans;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/c9d2bcab-2526-4c7c-a9f2-545ef0f789b8)

# go
```
var map1 = map[byte]int{'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
func romanToInt(s string) (ans int) {
    n:=len(s)
    for i:=range s{
        value := map1[s[i]]
        if i<n-1 && value< map1[s[i+1]]{
            ans-=value
        }else{
            ans+=value
        }
    }
    return 
}
```
