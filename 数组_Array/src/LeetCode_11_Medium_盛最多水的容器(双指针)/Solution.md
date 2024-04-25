# 题目
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。

![image](https://github.com/17230592226/LeetCode/assets/57279736/97ae4018-9997-4e18-a14c-0e4871a78166)

# 代码
![image](https://github.com/17230592226/LeetCode/assets/57279736/5518240d-9490-46d5-8b5c-f69410829793)
```
//只使用一次循环即可
class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;
        int res = 0;
        while (i < j) {
            if (height[i] < height[j]){
                res = max(res,(j-i)*(height[i]));
                i = i+1;
            }else{
                res = max(res,(j-i)*(height[j]));
                j = j -1;
            }
        }
        return res;
    }
};
```
![image](https://github.com/17230592226/LeetCode/assets/57279736/dbcd4649-2556-483e-914b-3be523ad682d)

# go语言
```
func maxArea(height []int) int {
  i,j := 0,len(height)-1
  res :=0
  for(i < j){
    if height[i] < height[j]{
       res = max(res,(j-i)*height[i])
        i +=1
    }else{
        res = max(res,(j-i)*height[j])
        j -=1
    } 
  }
  return res
}
```
