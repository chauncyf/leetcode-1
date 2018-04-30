### 75. Sort Colors
#### 题目
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

#### 思路
按照follow up里面思路写的代码：
```java

    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0) zero++;
            if(nums[i]==1) one++;
            if(nums[i]==2) two++;
        }
        for(int i = 0; i < zero; i++){
            nums[i] = 0;
        }
        for(int i = zero; i < zero+one; i++){
            nums[i] = 1;
        }
        for(int i = zero+one; i < zero+one+two; i++){
            nums[i] = 2;
        }
    }

```
接下来用one-pass算法。
```java

    public void sortColors(int[] nums) {
        int n1 = 0;
        int n2 = nums.length-1;
        int index = 0;
        while(index <= n2){
            if(nums[index] == 0){
                nums[index] = nums[n1];
                nums[n1] = 0;
                n1++;
            }
            if(nums[index] == 2){
                nums[index] = nums[n2];
                nums[n2] = 2;
                n2--;
                index--;
            }
            index++;
        }
    }

```
### 179. Largest Number
#### 题目
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: 210
Example 2:

Input: [3,30,34,5,9]
Output: 9534330
Note: The result may be very large, so you need to return a string instead of an integer.
#### 思路
直接重写了java的comparator：
```java

	public String largestNumber(int[] nums) {
        
        if(nums == null || nums.length == 0) return "";
        
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = nums[i]+"";
        } 
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return b.compareTo(a);
            }
        });
        //特殊情况：所有数字都为0
        if(strs[0].charAt(0) == '0') return "0";
        
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < strs.length; i++){
            result.append(strs[i]);
        } 
        return result.toString();
    }

```
### 349. Intersection of Two Arrays
#### 题目
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

#### 思路
用hashset做可以很简单
```java

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] intersect = new int[result.size()];
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        return toArray(result);
    }
    public int[] toArray(HashSet<Integer> set){
        int i = 0;
        int[] result = new int[set.size()];
        for(int element:set){
            result[i++] = element;
        }
        return result;
    }

```
