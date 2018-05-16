## Backtracking
回溯法(探索与回溯法)是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”

以下文字解决了我的一点困惑（引用自：https://segmentfault.com/a/1190000006121957）
有一些爱混淆的概念：递归，回溯，DFS。
回溯是一种找路方法，搜索的时候走不通就回头换路接着走，直到走通了或者发现此山根本不通。
DFS是一种开路策略，就是一条道先走到头，再往回走一步换一条路走到头，这也是回溯用到的策略。在树和图上回溯时人们叫它DFS。
递归是一种行为，回溯和递归如出一辙，都是一言不合就回到来时的路，所以一般回溯用递归实现；当然也可以不用，用栈。

### 78. Subsets
#### Problem
```text
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```
#### Solution
这是一条经典的回溯题
0   1 -- 2 -- 3
    |
1   2
    |
2   3
回溯过程示例：
null - add
[1] - add
[1,2] - add
[1,2,3] - add
[1,2] - X
[1] - X
[1,3] - add
[1] - X
null - X
[2] - add
[2, 3] - add
[2] - X
null - X
[3] - add
null - X
end of for loop
时间复杂度2^n，空间复杂度n
```java
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case
        if(nums == null || nums.length == 0) return res;
        List<Integer> sub = new ArrayList<>();
        helper(nums, res, sub , 0);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sub, int index){
        res.add(new ArrayList<>(sub));
        for(int i = index; i < nums.length; i++){
            sub.add(nums[i]);
            helper(nums, res, sub , i+1);
            //backtracking
            sub.remove(sub.size() - 1);
        }
    }
```
### 90. Subsets II
#### Problem
```text
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```
#### Solution
和subsetI很像，唯一的不同就是有duplicates，因此我们需要一个去重的过程
[1]
[1,2]
[1,2,2']
[1,2'] -
[2]
[2,2']
[2'] -
时间复杂度2^n，空间复杂度n
```java
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums); //为了去重先排序
        helper(nums, res, sub, 0);
        return res;
        
    }
    
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sub, int index){
        
        res.add(new ArrayList<>(sub));
        for(int i = index; i < nums.length; i++){
            //如果nums[i]曾经出现过，则越过本次循环
            if(i != index && nums[i - 1]==nums[i]) continue;
            sub.add(nums[i]);
            helper(nums, res, sub, i+1);
            sub.remove(sub.size() - 1);
        }
    }
```



