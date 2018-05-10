### 176. Second Highest Salary
#### Problem

Write a SQL query to get the second highest salary from the Employee table.
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

#### Solution
two versions:
```mysql
SELECT(
    SELECT max(Salary)
    FROM Employee
    WHERE Salary < (SELECT max(Salary) FROM Employee)
    )
AS SecondHighestSalary;

```
```mysql
select (
    select distinct Salary 
    from Employee 
    order by Salary Desc 
    limit 1 
    offset 1
)as SecondHighestSalary;
```
### 82. Remove Duplicates from Sorted List II
#### Problem

#### Solution


### 82. Remove Duplicates from Sorted List II
#### Problem

#### Solution
