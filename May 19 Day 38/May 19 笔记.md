### 125. Valid Palindrome
#### Problem
```text
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
```
#### Solution
思路：去掉所有标点符号和空格。然后把所有字母都变成小写。最后进行检验即可。
```java
    public boolean isPalindrome(String s) {
        s = s.replaceAll( "\\p{Punct}", "" );
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
```
但是正则表达式好慢啊。可以从两端向中间遍历。如果两者有任何一个不是数字或字母，则向中间移动一位。仅当两者都为数字/字母时，我们才进行比较.
```java
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int head = 0; 
        int tail = s.length() - 1;
        while(head <= tail){
            char headchar = s.charAt(head);
            char tailchar = s.charAt(tail);
            if(!Character.isLetterOrDigit(headchar)){
                head++;
            }else if(!Character.isLetterOrDigit(tailchar)){
                tail--;
            }else{
                if(headchar!=tailchar) return false;
                head++;
                tail--;
            }
        }
        return true;
    }
```
这个比之前的快多了，但是还不够！s.toLowerCase()应该比较慢，可以放到后面比较char的时候再转换：
```java
	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int head = 0; 
        int tail = s.length() - 1;
        while(head <= tail){
            char headchar = s.charAt(head);
            char tailchar = s.charAt(tail);
            if(!Character.isLetterOrDigit(headchar)){
                head++;
            }else if(!Character.isLetterOrDigit(tailchar)){
                tail--;
            }else{
                if(Character.toLowerCase(headchar) != Character.toLowerCase(tailchar)) return false;
                head++;
                tail--;
            }
        }
        return true;
    }
```