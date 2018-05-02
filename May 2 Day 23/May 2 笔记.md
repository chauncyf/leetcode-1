### 169. Majority Element
#### 题目
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

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
``` java

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
