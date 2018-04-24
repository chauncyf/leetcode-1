### 171. Excel Sheet Column Number
#### 题目描述
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
```

#### 思路
循环一下？
```java

    public int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        for(int i = 0; i < array.length; i++){
            count = count*26 + (array[i]-64);
        }
        return count;
    }

```
不过我看其他人的代码似乎都是写的(array[i]-'A'+1)这样子。

### 66. Plus One
#### 题目描述

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

#### 思路
```java

    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int[] result;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
//      当所有i都等于9，循环无法通过return digits结束时，运行以下代码：
        result = new int[n+1];
        result[0] = 1;
        return result;
        
    }

```

### 153. Find Minimum in Rotated Sorted Array	
#### 题目描述

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example:

Input: [3,4,5,1,2],
Output: 1

#### 思路

先排序，后取第一个【捂脸】尴尬的解法
```java

    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

```
java的sort貌似是O(nlogn)的
或者很蠢的遍历O(n)...
```java

    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(min > nums[i]) min = nums[i];
        }
        return min;
    }

```

但还有最快的一个方法binary search!(logn)

```java
    
//  找到中间位置mid，如果nums[mid] < nums[mid - 1]，那么nums[mid]就是最小值；
//  如果nums[mid] >= nums[start]且nums[mid]  >= nums[end],那么最小值肯定在右半部分，则让start = mid;
    public int findMin(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        
        if(nums.length == 1) return nums[0];
        
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start+end)/2;
            if(mid >= 1 && nums[mid] < nums[mid - 1]) return nums[mid];
            if(nums[start] <= nums[mid] && nums[mid]  >= nums[end])
                start = mid + 1;
            else
                end = mid -1;
                
        }
        return nums[start];
    }

```

测试例子里，第一个最慢，第二个第三个差不多哎～