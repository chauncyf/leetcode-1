### 164. Maximum Gap
#### 题目

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

#### 思路

随便写了个居然过了：
``` java

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