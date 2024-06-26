# 题目
121. 买卖股票的最佳时机
简单
相关标签
相关企业
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 

示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 

提示：

1 <= prices.length <= 105
0 <= prices[i] <= 104

# 代码
```
//下面这段代码 超出时间限制
//想法是：双层循环，找到每个数之后的最大值，然后相减。
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int low = 0;
        int high = prices.size() - 1;

        int ans = 0;

            for(low = 0 ; low < prices.size() - 1; low++){
                for(high = low+1 ; high < prices.size() ; high++){
                    int dif = prices[high] - prices[low];
                    if(dif > ans){
                        ans = dif;
                    }
                }
            }
            return ans;
            
        }
    
};
```

```
//超出时间限制
//想法是：记录最大值，然后第i值之后的最大值，然后利用最大值减去该值。
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max = 0;
        int ans = 0;
      // 这个是避免第一个值是最大值。与后面的(prices[i] == max)相对应。
        for(int j = 0; j < prices.size() ; j++){
                    if(prices[j] > max){
                        max = prices[j];
                }
        }


        for(int i = 0; i < prices.size() - 1 ; i++){
            if(prices[i] == max ){
                max = 0; //这里搞错了，选择最大值时，一定要设置max=0
                for(int j = i + 1; j < prices.size() ; j++){
                    if(prices[j] > max){
                        max = prices[j];
                    }
                }
            }
            else{
                int dif = max - prices[i];
                    if(dif > ans){
                        ans = dif;
                    }
            }
        }
        return ans;
            

           
    }      
    
};
```

```
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        int minx = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.size(); i++){
            minx = min(minx,prices[i]);
            maxProfit = max(maxProfit,prices[i] - minx);
        }
        return maxProfit;
    }      
    
};
```
# 思路
我们来假设自己来购买股票。随着时间的推移，每天我们都可以选择出售股票与否。那么，假设在第 i 天，如果我们要在今天卖股票，那么我们能赚多少钱呢？
<br/>
显然，如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！太好了，在题目中，我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
</br>
因此，我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。

# 时间复杂度
- 时间复杂度：O(n)，只需要遍历一次。
- 间复杂度：O(1)，只使用了常数个变量。

# go语言
# 代码
```
func maxProfit(prices []int) int {
    minx:= prices[0]
    maxProf :=0
    for _,v:=range prices{
        minx = min(minx , v)
        maxProf = max(maxProf,v-minx)
    }
    return maxProf
}
```
