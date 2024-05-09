# 题目
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

对于给定的输入，保证和为 target 的不同组合数少于 150 个。

 ![image](https://github.com/17230592226/LeetCode/assets/57279736/42894e4c-3ccc-481f-84b9-4e33301f793d)

# go代码
```
func dfs(candidates []int,res* [][]int,combain* []int ,target int,idx int){
    if idx==len(candidates){
        return 
    }
    if target == 0{
//注意：这里不能写成*res = append(*res, *combain)
        *res = append(*res, append([]int(nil), *combain...))
        return 
    }
//新的元素
    dfs(candidates,res,combain,target,idx+1)
//当前元素
    if target-candidates[idx] >= 0{
        *combain = append(*combain,candidates[idx])
        dfs(candidates,res,combain,target-candidates[idx],idx)
        *combain = (*combain)[:len(*combain)-1]
    }
}




func combinationSum(candidates []int, target int) [][]int {
    res:=[][]int{}
    combain:=[]int{}
    dfs(candidates,&res,&combain,target,0)
    return res
}
```

# go题解2
```
func combinationSum(candidates []int, target int) (ans [][]int) {
	comb := []int{}
	var dfs func(target, idx int)
	dfs = func(target, idx int) {
		if idx == len(candidates) {
			return
		}
		if target == 0 {
			ans = append(ans, append([]int(nil), comb...))
			return
		}
		// 直接跳过
		dfs(target, idx+1)
		// 选择当前数
		if target-candidates[idx] >= 0 {
			comb = append(comb, candidates[idx])
			dfs(target-candidates[idx], idx)
			comb = comb[:len(comb)-1]
		}
	}
	dfs(target, 0)
	return
}
```
