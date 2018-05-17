### 46. Permutations
#### Problem
```text
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```
#### Solution
Backtracking.和sublet题非常像
```java
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        List<Integer> sublist = new ArrayList<>();
        helper(nums, res, sublist);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sublist){
        if(sublist.size() == nums.length) {
            //这里一定要new一个list，因为sublist本身最后会变成null，
            //如果在这时不放入一个新的list，最后的结果会变成全空的！
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(sublist.contains(nums[i])) continue;
            sublist.add(nums[i]);
            helper(nums, res, sublist);
            sublist.remove(sublist.size() - 1);
        }
    }
```
### 47. Permutations II
#### Problem
```text
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

#### Solution
基本思想和subletII很类似，先排序，
排序后数组[1，1‘，2]:
1，1‘，2 - X
1，2，1’ - X
1‘，1，2 - add
1’，2，1 - add
2，1，1‘ - X
2，1’，1 - add
当1已经被使用，1'就不再加入sublist，即可避免duplicate的情况。

即：当前数字与上一个数字相同的情况下，若上一个数字已经加入sublist，则不再加入当前数字。

但是和subletII不同的是，因为forloop是从0而不是index开始遍历，我们需要另外想办法排除那些已经加入sublist的数字，防止同位置的数重复加入。

这里我参考了discuss区某个同学的办法：

新建一个boolean array(used)，用来表示nums各位置上的数字是否已经被使用。
当我们在sublist中新增nums[i]时，used[i] = true；当我们在sublist中去除元素时，used[i] = false;

```java
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0 || nums == null) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> sublist = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, sublist, used);
        return res;
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> sublist, boolean[] used){
        if(sublist.size() == nums.length) {
            //这里一定要new一个list，因为sublist本身最后会变成null，
            //如果在这时不放入一个新的list，最后的结果会变成全空的！
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //用过的不要
            if(used[i]) continue;
            //和subsetII类似
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == true) continue;
            sublist.add(nums[i]);
            used[i] = true;
            helper(nums, res, sublist, used);
            used[i] = false;
            sublist.remove(sublist.size() - 1);
            
        }
    }
```

### 60. Permutation Sequence
#### Problem
```text
Integer set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
```
#### Solution
其实可以按照PermutationsI的办法，全部求出来，然后返回res.get(k-1)。但是这么做太慢了！此处应有更高效的方法。discuss区有大神提供了很棒的思路。展示如下。
```text
n = 4, k = 9时，一共24种permutaion，分别可以表示为：
6 1 + 234的permutations
6 2 + 134的permutations
6 3 + 124的permutations
6 4 + 123的permutations
(k-1) / 6 = 1 ...2
所以kth是2 + 134的permutaions中的第三个
134的permutation又可以表示为：
2 1 + 34的permutations
2 3 + 14的permutations
2 4 + 13的permutations
2 / 2 = 1 ...0
所以kth时3 + 14的permutations中的第一个
14的permutation又可以表示为:
1 1 + 4的permutations(这里就是4)
1 4 + 1的permutations(这里就是1)
0 / 1 = 0 ... 0
即4
所以最后的结果应为：
2 3 1 4
```
用这个思路来求解的话，有如下代码：
```java
	public String getPermutation(int n, int k) {
		//生成顺序正整数数列
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        int[] f = new int[n+1];
        //生成每一步需要的factorial
        f[0] = 1;
        int sum = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            f[i] = sum;
        }
        //开始计算
        k = k - 1;
        StringBuilder res = new StringBuilder();
        //要注意！错误点：i=0；
        //第一个被除以的阶乘应该是(n-1)!，而不是n!
        //res的长度应为n，所以共循环n次
        for(int i = 1; i < n + 1; i++){
            int pos = k/f[n-i];
            res.append(nums.get(pos));
            nums.remove(pos);
            k = k%f[n-i];
        }
        return res.toString();
    }
```
### 181. Employees Earning More Than Their Managers
#### Problem
```text
The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
```
#### Solution
```mysql
SELECT e1.Name as Employee
FROM Employee e1, Employee e2
WHERE e1.ManagerId = e2.id
And e1.Salary > e2.Salary
```
