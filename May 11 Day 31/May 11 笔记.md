### 176. Second Highest Salary
#### Problem
```text
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
```
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
### 67. Add Binary
#### Problem
```text
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
```

#### Solution
用carry来代表是否进一位，对每一次计算进行标记，并将carry用于下一位计算。
到最后，如果carry==0那么代表不需要多一位，否则就需要多进一位。
```java
public String addBinary(String a, String b) {
        int A = a.length() - 1,
        B = b.length() - 1,
        carry = 0;
        StringBuilder res = new StringBuilder();
        while(A >= 0 || B >= 0){
            int sum = carry;
            if(A >= 0) sum += a.charAt(A--) - '0';  
            if(B >= 0) sum += b.charAt(B--) - '0';
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
```

### 82. Remove Duplicates from Sorted List II
#### Problem

#### Solution
