### 58. Length of Last Word
### Problem
```text
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
```
### Solution
```java
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        if(a.length == 0 || a == null) return 0;
        return a[a.length - 1].length();
    }
```
好像不够快，换个试试：
```java
public int lengthOfLastWord(String s) {
    if(s == null || s.length() == 0) return 0;
    int count = 0;
    int pointer = s.length() - 1;
    while(pointer >= 0 && s.charAt(pointer) == ' ') pointer--;
    while(pointer >= 0 && s.charAt(pointer--) != ' ') count++;
    return count;
}
```
第二种应该会在某些情况下更快，因为s.split需要遍历整个字符串，pointer大部分时候只会遍历一部分
