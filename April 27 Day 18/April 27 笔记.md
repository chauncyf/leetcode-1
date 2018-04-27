### 9. Palindrome Number
#### 题目
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

#### 解法
就很简单粗暴...
```java

    public boolean isPalindrome(int x) {
        String p = Integer.toString(x);
        for(int i = 0; i < p.length()/2+1; i++){
            if(p.charAt(i) != p.charAt(p.length()-i-1)) return false;
        }
        return true;
    }

```
应该也可以像之前的一题那样，reverse一半，然后进行比较～