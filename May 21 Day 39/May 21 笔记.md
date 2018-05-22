### 77. Combinations
#### Problem
```text
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```
#### Solution
今天的几道题都是backtracking，只有一点细微的不同～
```java
public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, n, k, 1);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
        if(k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            helper(res, list, n, k - 1, i+1);
            list.remove(list.size() - 1);
        }
    }
```

### 39. Combination Sum
#### Problem
```text
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```
#### Solution
```java
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, target, 0, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int sum, int start){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            sum += candidates[i];
            helper(res, list, candidates, target, sum, i);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        
    }
```

### 40. Combination Sum II
#### Problem
```text
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
```
#### Solution
```java
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, target, 0);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            //去重
            if(i != start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            target -= candidates[i];
            //同一位置的数字不可重复使用
            helper(res, list, candidates, target, i + 1);
            target += list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
```
### 183. Customers Who Never Order
#### Problem
```text
Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

```
#### Solutions

```sql
SELECT a.Name AS Customers
FROM Customers a
WHERE a.Id NOT IN(
    SELECT b.CustomerId
    FROM Orders b
    JOIN Customers a
    ON b.CustomerId = a.Id
);
```

简化一下：
```sql
SELECT Name AS Customers
FROM Customers
WHERE Id NOT IN(
    SELECT CustomerId
    FROM Orders
);
```

也可以用leftjoin：
```sql
SELECT Name AS Customers 
FROM Customers
LEFT JOIN Orders
ON Customers.Id = Orders.CustomerId
WHERE Orders.CustomerId IS NULL;
```
