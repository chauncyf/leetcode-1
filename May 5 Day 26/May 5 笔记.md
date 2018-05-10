### 13. Roman to Integer
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