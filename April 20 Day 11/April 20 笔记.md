### 141. Linked List Cycle
#### 题目描述

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

#### 思路
先把head存储，然后遍历linkedlist，如果遍历中的某个节点就是head，那么就存在环，否则就不存在：
``` java

    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        while(head != null && head.next!=null){
            if(head.next == temp) return true;
            head = head.next;
        }
        return false;
    }

```
然而这种解法报了错！因为这个链表可能是这样的：

```
1 -> 2 -> 3
 (上)|    |(下)
     5 <- 4
```

参考了评论区大佬的解法，假设有两个速度不同的点同时从带环链表上的一个点出发同向走，那么这两个点总会汇合。代码如下：

```java

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(head != null &&fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true; 
        }
        return false;
    }


```

这样就通过测试了～

### 128. Longest Consecutive Sequence
#### 题目描述

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

#### 思路
代码还有问题，时间有限，明天继续。
``` java

	public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i], i);
            if(map.containsKey(nums[i]-1)){
                union(i, map.get(nums[i]-1), parent);
            }
            if(map.containsKey(nums[i]+1)){
                union(i, map.get(nums[i]+1), parent);
            }
         
        }
        
        return getMax(parent);

    }
    
    int getParent(int a, int[] parent){
        while(a != parent[a]){
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return parent[a];
    }
    
    void union(int p, int q, int[] parent){
        if (getParent(p, parent) != getParent(q, parent)){
            parent[q] = parent[p];
        }
    }
    
    int getMax(int[] parent){
        int m = parent.length;
        int[] count = new int[m];
        int max = 0;
        for(int i = 0; i < m; i++){
//          所有跟节点计数
            count[getParent(i, parent)]++;
            max = Math.max(max, count[getParent(i, parent)]);
        }
        return max;
    }

``` 

### 778. Swim in Rising Water
#### 题目描述

On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., NN - 1].

#### 思路

``` java

```
