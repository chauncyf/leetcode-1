### 12. Integer to Roman
#### Problem
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbols     Value
I   1
V   5
X   10
L   50
C   100
D   500
M   1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

#### Solution
我使用了很笨的办法，把所有情况罗列判断：
```java
    public String intToRoman(int num) {
        String n = String.valueOf(num);
        int cd = n.length() - 1;
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < n.length(); j++){
            int number = n.charAt(j) - '0';
            if(cd == 3){
                for(int i = 0; i < number; i++){
                    result.append("M");
                }
            }
            if(cd == 2){
                if(number == 9) result.append("CM");
                if(number >= 5 && number < 9) {
                    result.append("D");
                    for(int i = 0; i < number - 5; i++){
                        result.append("C");
                    }
                }
                if(number == 4) result.append("CD");
                if(number < 4) {
                    for(int i = 0; i < number - 0; i++){
                        result.append("C");
                    }
                }
            }
            if(cd == 1){
                if(number == 9) result.append("XC");
                if(number >= 5 && number < 9) {
                    result.append("L");
                    for(int i = 0; i < number - 5; i++){
                        result.append("X");
                    }
                }
                if(number == 4) result.append("XL");
                if(number < 4) {
                    for(int i = 0; i < number - 0; i++){
                        result.append("X");
                    }
                }
            }
            if(cd == 0){
                if(number == 9) result.append("IX");
                if(number >= 5 && number < 9) {
                    result.append("V");
                    for(int i = 0; i < number - 5; i++){
                        result.append("I");
                    }
                }
                if(number == 4) result.append("IV");
                if(number < 4) {
                    for(int i = 0; i < number - 0; i++){
                        result.append("I");
                    }
                }
            }
            cd--;
        }
        return result.toString();
    }

```
然后看见评论区一个大佬的很棒的答案！！！只有五行！！！先把个十百千位上可能出现的所有数字都放入各自的数组，然后
```java
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[num%1000/100] + X[num%100/10] + I[num%10];
    }
```
果然大佬还是你大佬hhhh比我简洁还比我快

### 19. Remove Nth Node From End of List
#### Problem
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

#### Solution
可以用之前找linkedlist中点的办法！设置两个pointer,一个跑的快，一个跑的慢。两个pointer相差2的时候，同速跑。等快的pointer跑到最后一个listnode，慢的那个应该就跑到倒三的位置啦。然后删掉他后面那个就ok。
```java
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        //注意特殊情况！
        //第一次写的时候没看到，结果报错了。
        //当linkedlist和n的长度一致时，直接删去第一个node。
        //因为和下面的算法比，fast和slow多进了一格，应该删除的不再是slow.next而是slow本身
        if(fast == null) return head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
        
    }
```
### 20. Valid Parentheses
#### Problem
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

#### Solution
可以用stack做～时间复杂度n,空间复杂度n
```java
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{') stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(isCouple(stack.peek(), c)) stack.pop();
                else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
        
    }
    
    public boolean isCouple(char a, char b){
        
        if(a == '[' && b == ']' || a=='(' && b == ')' || a == '{' && b == '}') return true;
        return false;
        
    }
```

### 24. Swap Nodes in Pairs
#### Problem
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.

#### Solution
iterative(0(n)):
```java

    public ListNode swapPairs(ListNode head) {
        
        if(head == null) return null;
        
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp = fake;
        
        while(right != null){
            ListNode temp1 = right.next;
            left.next = temp1;
            right.next = left;
            temp.next = right;
            temp = left;
            left = temp.next;
            if(left != null) right = left.next;
            else right = null;
        }
        
        return fake.next;
    }

```
recursive:
```java
    public ListNode swapPairs(ListNode head) {
        
        if ((head == null)||(head.next == null))
            return head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp = swapPairs(head.next.next);
        left.next = temp;
        right.next = left;
        head = right;
        return head;
        
    }
```

### DB 175. Combine Two Tables
#### Problem
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

FirstName, LastName, City, State

#### Solution
```MYSQL
# SQL LEFT JOIN 
# LEFT JOIN 关键字会从左表 (table_name1) 那里返回所有的行，即使在右表 (table_name2) 中没有匹配的行。
# 因为我们的Person未必都会有Address数据，因此我们可以使用LEFT JOIN
# 基本语法：
# SELECT column_name(s)
# FROM table_name1
# LEFT JOIN table_name2 
# ON table_name1.column_name=table_name2.column_name

SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person 
Left JOIN Address
ON Person.PersonId = Address.PersonId;
```
还可以使用outer join，原因类似：
```MYSQL
SELECT FirstName, LastName, City, State
FROM Person left join Address
ON Person.PersonId = Address.PersonId;
```