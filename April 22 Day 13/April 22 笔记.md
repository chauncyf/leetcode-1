### 203. Remove Linked List Elements
#### 题目描述
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

#### 思路
思路其实很简单，先通过while循环找出第一个值不等于val的节点。然后从这个节点开始，依次检验之后的节点，如遇到值等于val的节点，则删去，这一过程与昨天的那条Remove Duplicates from Sorted List有点像。代码如下：

``` java

    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) return head;
        
        while( head != null && head.val == val) head = head.next;
        
        ListNode temphead = head;
        while (temphead != null && temphead.next != null)
            
            if(temphead.next.val == val) 
                temphead.next = temphead.next.next;
            else
                temphead = temphead.next;
        
        return head;
    }

``` 

需要注意的两点是：
1.第一行代码其实不需要
2.第二行代码那里，head != null一定要放在head.val == val之前，否则会出现null pointer exception，一开始我就写错了，找了半天才发现这个问题......

### 234. Palindrome Linked List
#### 题目描述
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

#### 思路
先找到这个linkedlist的中点，然后reverse the second half，最后将first half和它比较，如果一样则是Palindrome。

```java
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
        
    }

    public ListNode reverse(ListNode head){
       
        ListNode next = head.next;
        head.next = null;
        
        while(next != null){
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        
        return head;
        
    }

```
### 328. Odd Even Linked List
#### 题目描述
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

#### 思路

```java

    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode headeven = even;
        
        while(even != null && even.next != null){

            odd.next = odd.next.next;
            odd = odd.next;
            even.next  = even.next.next;
            even = even.next;
                
        }
        odd.next = headeven;
        return head;
    }
    
```

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
