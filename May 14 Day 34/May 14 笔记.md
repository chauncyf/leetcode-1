### 4. Median of Two Sorted Arrays
#### Problem
```text
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
#### Solution
还是可以用merge sort呢！先将两个array合并生成一个sorted array，然后找它的medium就好。
```java
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int left = nums1.length - 1;
        int right = nums2.length - 1;
        int len = left + right + 2;
        int[] nums = new int[len];
        while(left >=0 && right >= 0){
            if(nums1[left] > nums2[right]) {
                nums[left+right+1] = nums1[left];
                left--;
            }else{
                nums[left+right+1] = nums2[right];
                right--;
            }
        }
        while(left >= 0){
            nums[left] = nums1[left];
            left--;
        }
        while(right >= 0){
            nums[right] = nums2[right];
            right--;
        }
        if(len%2==0){
            return (nums[len/2]+nums[len/2 - 1])/2.0;
        }else{
            return nums[len/2];
        }
    }
```

### 119. Pascal's Triangle II
#### Problem
```text
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
```
#### Solution
和I差不多哎～还少点步骤呢
```java
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            result.add(1);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(result);
            for(int j = 1; j < result.size() - 1; j++){
                result.set(j, temp.get(j-1) + temp.get(j));
            }
        }
        return result;
    }
```
