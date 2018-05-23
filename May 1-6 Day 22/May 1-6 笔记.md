### 164. Maximum Gap
#### 题目
```text
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either 3,6 or 6,9 has the maximum difference 3. 
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.
```
#### 思路

随便写了个居然过了：
```java

    public int maximumGap(int[] nums) {
        int max = 0;
        if (nums.length < 2 || nums == null) return max;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i+1] - nums[i] > max) max = nums[i+1] - nums[i];
        }
        return max;
    }

```
但是这显然不是linear的，因为Arrays.sort()方法并不是O(n)。
评论里有其他方法，今天外出太累了，快凌晨一点了才吃完晚饭，明天再写吧。

### 169. Majority Element
#### 题目
```text
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
```
#### 思路
排序法
```java

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[i+nums.length/2]) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

//改进
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

```
hashmap
```java

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(map.get(nums[i]) > nums.length/2){
                result = nums[i];
                break;
            }
        }
        return result;
    }

```
divide and conquer留空

### 13. Roman to Integer
#### 题目
```text
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
```
#### 思路
一个比较直白的解法：先加后减。
```java

    public int romanToInt(String s) {
        char schar[] = s.toCharArray();
        int sum = 0;
//      先全部加起来
        for(int i = 0; i < s.length(); i++){
            if(schar[i] == 'I') sum += 1;
            if(schar[i] == 'V') sum += 5;
            if(schar[i] == 'X') sum += 10;
            if(schar[i] == 'L') sum += 50;
            if(schar[i] == 'C') sum += 100;
            if(schar[i] == 'D') sum += 500;
            if(schar[i] == 'M') sum += 1000;
        }
        
//      如果出现减法情况，减去双倍
        if(s.contains("IV")) sum -= 2;
        if(s.contains("IX")) sum -= 2;
        if(s.contains("XL")) sum -= 20;
        if(s.contains("XC")) sum -= 20;
        if(s.contains("CD")) sum -= 200;
        if(s.contains("CM")) sum -= 200;
        
        return sum;
    }

```

评论区还有一个很聪明的办法：将string转换成的charset转换为各自对应数字组成的数组。如果当前数字大于等于下一个数字，则加当前数字，否则减去当前数字。

```java

    public int romanToInt(String s) {
        int nums[]=new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return (sum+nums[nums.length-1]);
    }


```

### 769. Max Chunks To Make Sorted
#### 题目
```text
Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
```
#### 思路
```java

    public int maxChunksToSorted(int[] arr) {
        
        int count = 0;
//      从开始到现在位置中的最大值array
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            max[i] = Math.max(max[i-1], arr[i]);
        }
//      如果max[i]和排序后的arr[i]相等，那么计数增加1。因为题目规定arr是由0～arr.length-1乱序组成的数组，所以只用max[i]和i比较就好，不需要另外排序，这也让算法复杂度保持在了O(n)
//      For example,
//      original: 0, 2, 1, 4, 3, 5, 7, 6
//      max:      0, 2, 2, 4, 4, 5, 7, 7
//      sorted:   0, 1, 2, 3, 4, 5, 6, 7
//      index:    0, 1, 2, 3, 4, 5, 6, 7
        for(int i = 0; i < arr.length; i++){
            if(max[i] == i) count++;
        }
        return count;
    }

```
### 118. Pascal's Triangle
#### 题目
```text
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```
#### 思路

一行行计算即可

一：从后往前算
```java

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            for(int j = newline.size()-1; j >= 1; j--){
                newline.set(j, newline.get(j) + newline.get(j-1));
            }
            newline.add(1);
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }
```

二：从前往后算：
```java

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            newline.add(1);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(newline);
            for(int j = 1; j < newline.size() - 1; j++){
                newline.set(j, temp.get(j-1) + temp.get(j));
            }
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }

```

显然第一种方法更快啦！不过评论区大佬有个从前往后还很快的法子：
```java

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> newline = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            newline.add(0, 1);
            for(int j = 1; j < newline.size()-1; j++){
                newline.set(j, newline.get(j) + newline.get(j+1));
            }
            result.add(new ArrayList<Integer>(newline));
        }
        return result;
    }

```
