### 520. Detect Capital
#### 题目描述

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

#### 思路
感觉很简单唉...
``` java
class Solution {
    public boolean detectCapitalUse(String word) {
        char[] wordchar = word.toCharArray();
        HashSet wordset = new HashSet();
        if(Character.isLowerCase(wordchar[0])){
            for(int i = 0; i < wordchar.length; i++){
                if(Character.isLowerCase(wordchar[i])){
                    wordset.add(0);
                }else{
                    wordset.add(1);
                }
            }
        }else{
            for(int i = 1; i < wordchar.length; i++){
                if(Character.isLowerCase(wordchar[i])){
                    wordset.add(0);
                }else{
                    wordset.add(1);
                }
            }
        }
        if (wordset.size()==1 ||wordset.size()==0)
            return true;
        return false;
    }
}
```
先判断第一个字母的大小写；如果是小写，那么剩下的都只能是小写（0），从0～(n-1)进行判断生成的hashset大小只能是1；如果是大写，那么剩下的要么全大写，要么全小写，要么啥都没有，即从1～(n-1)进行判断生成的hashset大小只能是1或0。复杂度是O(n)，应该还成吧。但是评论区有很多棒棒的方法哦。

#### 十分简短的代码
##### 1.
用ascii码加减对大小写进行判断，并且对大写字母计数。大小写正确的条件有：没有大写字母，大写字母个数正好是char数组的长度，大写字母只有一个而且是第一个。代码如下：
``` java

class Solution {
    public boolean detectCapitalUse(String word) {
        char[] wordchar = word.toCharArray();
        int count = 0;
        for(char c: wordchar) if(c <='Z') count++;
        return(count==0 || count == wordchar.length || count==1&&wordchar[0] < 'Z');
    }
}

``` 
##### 2.
如果第一个字母是小写，则剩下的字符串变小写后要和原来相同
如果第二个字母是大写，则剩下的字符串要么变大写后和原来相同，要么变小写后和原来相同
``` java
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        return Character.isUpperCase(word.charAt(0)) ? word.substring(1).equals(word.substring(1).toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase()) : word.substring(1).equals(word.substring(1).toLowerCase
        ());
    }
}

```
##### 3.
话说python里居然有现成的方法可以用......
```python
def detectCapitalUse(self, word):
    return word.isupper() or word.islower() or word.istitle()
```
或者：
```python
def detectCapitalUse(self, word):
	return len(word)==1 or word[1:].islower() or word.isupper()
```
也行......这不公平【掩面