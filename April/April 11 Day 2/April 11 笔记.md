### 1. Two Sum
#### 题目描述
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

#### 思路
1. 最简单的就是循环嵌套，但是不好。看见讨论区有用Hashmap(时间复杂度O(1))做的，所以做了尝试：

``` java

public int[] twoSum(int[] nums, int target) {
    
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            result[1] = i;
            result[0] = map.get(target - nums[i]);
            return result;
        }
        map.put(nums[i], i);
    }
    return result;
}

```
看到评论区有人说如果有两个一样的数字怎么办，但其实题目条件已经排除了这一情况：each input would have exactly one solution。

### 167. Two Sum II - Input array is sorted
#### 题目描述

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1 = 1, index2 = 2

#### 思路
因为数组是从小到大排列的，所以可以先取出第一个和最后一个元素，如果两者之和大于target，则将取出倒数第二个元素代替最后一个元素；反之则取出第二个元素代替第一个元素。重复这个过程，直到找到最后的答案。（其实也可以用上题办法）
``` java
    public int[] twoSum(int[] numbers, int target) {
        
        int a = 0;
        int b = numbers.length-1;
        int[] result= new int[2];
        
        for(int i = 0; i < numbers.length-1; i++){
            
            if(numbers[a] + numbers[b] == target){
                result[0] = a+1;
                result[1] = b+1;
                break;
            }else if(numbers[a] + numbers[b] > target){     
                b = b-1;   
            }else if(numbers[a] + numbers[b] < target){        
                a = a+1;      
            }
        } 
    return result;
        
    }
```

### 170. Two Sum III - Data structure design
#### 题目描述
Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

#### 我的思路
感觉和第一题差不多

``` java
public class twoSumIII{

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int num){

        if(map.containsKey(num)){
            map.put(num, map.get(num)+1);
        }else{
            map.put(num, 1);
        }
        
    }

    public boolean find(int target){

        for (Integer i : map.keySet()) {
            if (map.containsKey(target - i)) return true;
        }
        return false;

    }

}
``` 
#### 讨论区
因为没有付费所以看不到啦～等付费了再回去看看补充。


