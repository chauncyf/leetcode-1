### 553. Optimal Division
#### 题目描述

Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

#### 思路
nums[0]/nums[1]/nums[2]/.../nums[n-1] 
=  nums[0]/nums[1] * Y
<= (nums[0]/nums[1]) * (nums[2] * nums[3] * nums[4]... * nums[n-1])
=  nums[0]/(nums[1]/nums[2]/.../nums[n-1])
```java

    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return Integer.toString(nums[0]);
        if(nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuffer numMax = new StringBuffer();
        numMax.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++){
            numMax.append("/" + nums[i]);
        }
        numMax.append(")");
        return numMax.toString();
    }

```
评论里有人认为可以用divide and conquer～
等学到这里了再补这个方法

### 343. Integer Break
#### 题目描述

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

#### 思路

就很蠢地遍历...

```java

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = i; j < n-1; j++){
                for(int k = j; k < n; k++){
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }
    public double area(int[] a, int[] b, int[] c){
        return Math.abs(a[0]*(b[1] - c[1]) + b[0]*(c[1] - a[1]) + c[0]*(a[1] - b[1]))/2.0;
    }

```

### 357. Count Numbers with Unique Digits

#### 题目描述

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

#### 思路

10^n中，Numbers with Unique Digits
1位的 10
2位的 9 * 9
3位的 9 * 9 * 8
4位的 9 * 9 * 8 * 7
......

```java

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int base = 9;
        int result = 10;
        for(int i = 1; i < n & i <= 10; i++){
            base = base*(9-i+1);
            result = result + base;
        } 
        return result;
    }

```
