### 136. Single Number
#### 题目描述
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

#### 我的解题思路
1. 先排序，后从第二个元素开始与相邻的前一个元素进行比较，一直循环到该元素与相邻元素不等时，return该元素的前一个元素；如果循环一直运行到结束，那么剩下的最后一个元素就是我们要找的那个single number。
``` java
  public int singleNumber(int[] nums) {
                
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length-1; i=i+2){
            if(nums[i]!=nums[i-1]){
                return nums[i-1];
            }
        }
        
        return nums[nums.length-1];
            
    }
```

##### 但是这种方法多了一个排序的过程，时间复杂度是O(nlogn)，并不符合题目的要求O(n)。
#### 讨论区学到的正解
翻看了讨论区后看到了一个很巧妙的答案！用XOR来计算。因为`a xor a = 0`; `a xor 0 = a`; `a xor b xor a = b`,所以有：
``` java
    public int singleNumber(int[] nums) {
                
        int result = nums[0];
        for(int i = 1; i < nums.length; i = i + 1){
            
            result = result^nums[i];
            
        }
        return result;
            
    }
```
### 771. Jewels and Stones
#### 题目描述
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Note:

* S and J will consist of letters and have length at most 50.
* The characters in J are distinct.

#### 我的思路
一开始没动脑，就瞎遍历了下。
``` java
    public int numJewelsInStones(String J, String S) {
        
	    char[] jlist = J.toCharArray();
		char[] slist = S.toCharArray();
        int result = 0;
        
        for(int i = 0; i < slist.length; i++){
            for(int j = 0; j < jlist.length; j++){
                if(jlist[j]==slist[i]) result++;
            }
        }
        
        return result;
		
    }
```
这样的话时间复杂度是O(MN),不好，仔细看note的第二条，提示了我们可以用hashset。

``` java
   public int numJewelsInStones(String J, String S) {
        
        int result = 0;
        Set Jset = new HashSet();
		char[] jlist = J.toCharArray();
        
        for(int i = 0; i < jlist.length; i ++){
            Jset.add(jlist[i]);
        }
        
		char[] slist = S.toCharArray();
        for(int j = 0; j < slist.length; j ++){
            if(Jset.contains(slist[j])) result++;
        }
        return result;
		
    }
}
```
因为hashset搜索的时间复杂度是O(1)，所以这样子的时间复杂度是O(M+N)，好多啦

#### 讨论区的大神
居然用的是正则表达式，真的想不到，可以的
``` java
    public int numJewelsInStones(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length(); //[^abc] matches everything that is not abc
    }
``` 
### 292. Nim Game
#### 题目描述
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

#### 我的思路
首先，所有4的倍数都不可以；对方完全可以每次都拿（4-我拿的石头数）；剩下的所有数字都可以用`4n+1`、`4n+2`、`4n+3`来表示（`n为自然数`），要么我可以一次拿光，要么我可以拿掉1～3个后，让剩下的数额是4的倍数，这样对方必输无疑。因此我的答案是：

``` java
public boolean canWinNim(int n) {
      if(n%4==0) 
          return false;
      else
          return true;
}
``` 
#### 讨论区
看见讨论区在用数学证明，可以的哈哈哈。


