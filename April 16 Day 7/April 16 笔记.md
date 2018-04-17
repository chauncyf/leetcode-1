### 326. Power of Three
#### 题目描述

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

#### 思路

法一：循环
```java

    public boolean isPowerOfThree(int n) {
        while(n%3==0 && n!=0){
            n = n/3;
        }
        if(n == 1) return true;
        return false;
    }

```

法二：递归
```java

	public boolean isPowerOfThree(int n) {
        return n>0 &&  (n==1 || (n%3==0 && isPowerOfThree(n/3)));
    }

```

法三：既不是循环，也不是递归
log3(n)是整数,log3(n) = logn/log3
```java

    public boolean isPowerOfThree(int n) {
        return (Math.log(n)/Math.log(3)) == Math.round(Math.log(n)/Math.log(3));
    }

```
但是报了错，243被漏掉了，应该是因为log3的数值都是近似值的缘故...看了评论区的解答，貌似把自然底数改掉就可以了，比如下面这个就能正常通过测试：
```java

	public boolean isPowerOfThree(int n) {
        return (Math.log10(n)/Math.log10(3))%1==0;
    }

```
法四：评论区看到的，一个简直是作弊的方法：
```java

    public boolean isPowerOfThree(int n) {
    	//int最大为：2147483647；1162261467 是 3^19,  3^20 就比int大了。  
        return n > 0 && (1162261467 % n == 0);
    }

```

### 202. Happy Number
#### 题目描述

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

#### 思路

可以使用hashset，如果现有的和无法加入hashset则说明原来的hashset中已经有了这个数字，之后只会永无休止的循环；如果现有的和是1，则该数字是happy number

```java

	public boolean isHappy(int n) {
        Set<Integer> loop = new HashSet<>();
        int squareSum;
        int remain;
        while(loop.add(n)){
            squareSum = 0;
            while(n>0){
//              计算所有digits的总和
                remain = n%10;
                squareSum = squareSum + remain*remain;
                n = n/10;
            }
//             如果总和为1，return true
            if(squareSum == 1) 
                return true;
//             否则另n=总和
            else 
                n = squareSum;
        }
        return false;
    }

```

### 202. Plus One
#### 题目描述
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

#### 思路
说实话我没看懂题目...讨论区有人给了比较详尽的解释：
[1, 2, 3, 4] represents integer 1234, add one to 1234(the length of array not changed), you get 1235. but [9, 9, 9, 9] represents 9999, add one to 9999, you get 10000(the length of array changed)

分两种情况：一种是加了位数不变；另一种是加了之后多一位：

```java

	public int[] plusOne(int[] digits) {

        int[] result;
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        result = new int[n+1];
        result[0] = 1
        return result;
        
    }
    
```