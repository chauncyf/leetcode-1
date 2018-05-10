### 176. Second Highest Salary
#### Problem

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
