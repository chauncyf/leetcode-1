### 137. Single Number II
#### 题目描述
Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
#### 思路
可以用和Single Number I 相似的方法：
```java
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        if(nums.length == 1) return nums[0];
        
        if(nums[0]!=nums[1]) return nums[0];
      
        for(int i = 1; i < nums.length - 1; i = i+3){

            if(nums[i]!=nums[i-1]) return nums[i-1];

        }
        return nums[nums.length - 1];
        
    }
```

#### 评论里大佬们的解法(bit operation)
我们可以建立一个32位的数字，统计每一位上1出现的个数。如果某一位上为1的数字出现三次，除以三余0，那么我们把每个数的对应位都加起来除以三取余，最后剩下来的那个数字就是那个single number。

``` java
public int singleNumber(int[] nums) {
        
        int result = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < nums.length; j++){
                if(((nums[j]>>i)&1) == 1){
                    sum++;
                    sum = sum%3;
                }
            }
            if(sum != 0){
                result = result | sum<<i;
            }
            
        }
        return result;
        
    }
```

### 765. Couples Holding Hands
#### 题目描述
N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.

#### 我的思路
最简单的就是贪婪算法，以位置i为例，查看i+1位置的是否是他的伴侣，如果是，则跳过i+1测试i+2；如果不是，则便利后面的数组，找到i的伴侣，并与i+1进行交换，并计数+1.但是既然这题是被放在unionfind类别的，我还是决定尝试unionfind法。

将一对夫妻想象为一个节点,一共有n个节点。如果2i和2i+1上是分别是夫妻q和夫妻p的其中一人，则union两夫妻p和q。循环这个过程，求出连通分量数后，拿n减去联通分量数则为最后我们需要swap的次数
``` java

//  初始化
    int[] root;
    int count;
    
    public int minSwapsCouples(int[] row) {
//      赋值
        int n = row.length/2;
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        count = n;
//      计算

        for(int i = 0; i < n; i++){
            int p = row[2*i];
            int q = row[2*i + 1];
            union(p/2, q/2);
        }
        return n-count;
    }
    
    public int find(int i){
        while (i != root[i]){
            i = root[i];
        }
        return i;
    }

    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
//          这里有前提条件：两个root必不同
        if(rootp != rootq){
            root[rootp] = rootq;
            count --;
        }
    }

``` 
#### 讨论区
预留一下位置，二刷的时候再加


### 260. Single Number III
#### 题目描述
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
#### 思路
还是用xor来做吧～
将原数组分成两个只带一个single number的小数组再来做就好了。
方法是：将所有数字异或，保留结果中从低位到高位的第一个1，其他位为0。
这个位置即是那两个single number第一次不一样的地方。
用这个数字分别与数组中的每一个元素进行与运算。就可以将这组数字分为两组，且两个single number必然被分在两组里。
```java

public int[] singleNumber(int[] nums) {
        
        int diff = 0;
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            diff ^= nums[i];
        }
        // 先取反再和原数进行与运算即可
        diff = diff & (-diff);

        for(int i = 0; i < nums.length; i++){
            if((nums[i] & diff) == 0){
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }
        
        return result;
        
    }

```
### 231. Power of Two
#### 题目描述
Given an integer, write a function to determine if it is a power of two.
法一：
一直除以2直到得到不能被2整除的整数，看是不是1
```java
	public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        while(n%2==0) n = n/2;
        return (n == 1);
    }
```

法二：
二进制下，2的n次方都是0...10000...(n-1个0);
2的n次方-1都是0...01111...(n-1个1);
那么2^n & 2^n-1 = 0...00000...(n个0);
其他数字都不能满足这个条件。
```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n>0 && (n & (n-1))==0) return true;//注意这里n一定要大于零，0和负整数都不可以算进去！（第一次打的时候犯的错）
        return false;
    }
}

```
法三：递归法
```java

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n == 1 || ((n%2) == 0 && isPowerOfTwo(n/2)));
    }
}

```