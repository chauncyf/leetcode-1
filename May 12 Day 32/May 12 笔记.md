### 88. Merge Sorted Array
#### Problem
```text
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```
#### Solution
这题我偷懒做了一个方法，居然过了[难以置信]：
```java
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m + n; i ++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }
```
不过显然，出题者一定不是希望我们这么偷懒的～所以，可以用mergesort的思想～
不过因为nums1后面n位都是空的，所以为了节省空间，我们免去copy数组的步骤，直接从后往前遍历找最大值即可。
```java
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for(int i = 0; i < n; i++) nums1[i] = nums2[i];
        }
        //mergesort
        int left = m - 1;
        int right = n - 1;
        int total = m + n - 1;
        while(left > -1 && right > -1){
            if(nums2[right] > nums1[left]){
                nums1[total--] = nums2[right--];
            }else{
                nums1[total--] = nums1[left--];
            }
        }
        while(right > -1) nums1[total--] = nums2[right--];
        while(left > -1) nums1[total--] = nums1[left--];
    }
```