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
### 28. Implement strStr()
#### Problem
```text
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
```
#### Solution
从haystack的index=0开始，分别检查haystack.substring(index, index + needlelength)和needle是否相等
```java
    public int strStr(String haystack, String needle) {
        
        int n = needle.length();
        int h = haystack.length();
        if(n == 0) return 0;
        if(h == 0 || n > h) return -1;
        for(int i = 0; i <= h - n; i++){
            if(haystack.substring(i, i + n).equals(needle)) return i;
            else continue;
        }
        return -1;
        
    }
```
discuss中有一个虽然也是brute-force，但是代码特别简洁漂亮的，拿来参考一下：
```java
    public int strStr(String haystack, String needle) {
      for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          //情况一
            //如果haystack的子string和needle一致，haystack的第i位到第i+needle.length()都应该等于needle的对应位
            //j只有在这种情况下才可以一直自累加至needle的长度
            //那么，当j = needle.length()的时候，我们就可以输出此时的i
          //情况二
            //如果needle是""，则按照题意输出0
          if (j == needle.length()) return i;
          //情况一
            //当i = haystack.length且needle不比haystack长时，说明从0遍历到i-1，都没找到和needle一致的substring
          //情况二
            //如果 haystack是""，说明haystack中没有needle的substring，因为这种情况下，i+j一开始就=0，
          //情况三
            //如果needle比haystack长，j总有可能增长至i+j=haystack的长度，这种情况显然应该输出-1
          if (i + j == haystack.length()) return -1;
          //只要j位的needle和i+j位的haystack不相等，就回去对i+1
          //j和i+j的初始值都是0，haystack总是从第i位开始比对，而needle总是从第0位开始比对
          if (needle.charAt(j) != haystack.charAt(i + j)) break;
        }
      }
    }
```
反正我肯定是写不出来这样的代码的～厉害！

### 14. Longest Common Prefix
#### Problem
```text
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

```
#### Solution
思路很简单，但是有个地方需要注意，不能犯错哇。
```java
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null) return "";
        String res = new String();
        res = strs[0];
        for(int i = 1; i < strs.length; i++){
            //注意这里strs[i].indexOf(res) != 0 而不是 != -1就好
            //因为我们不仅需要它存在，而且需要它在最前面
            while(strs[i].indexOf(res) != 0) res = res.substring(0, res.length() - 1);
        }
        return res.toString();
    }
```