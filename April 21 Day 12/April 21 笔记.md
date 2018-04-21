### 817. Linked List Components
#### 题目描述

We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:

Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:

Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
Note:

If N is the length of the linked list given by head, 1 <= N <= 10000.
The value of each node in the linked list will be in the range [0, N - 1].
1 <= G.length <= 10000.
G is a subset of all values in the linked list.

#### 思路
将G放入一个hashset里面，遍历linkedlist，分别测试节点的value是否存在于hashset中，如果从头到尾都在hashset中，则count++，否则，就跳过不存在于hashset的那个点，继续遍历，重复上述过程。

``` java

    public int numComponents(ListNode head, int[] G) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        int count = 0;
        
        while(head != null){
            boolean exist = false;
            while(head != null && set.contains(head.val)){
                exist = true;
                head = head.next;
            }
            if(exist) {
                count++;
            }
            if (head != null) {
                head = head.next;
            }
        }
        
        return count;
    }

```
### 83. Remove Duplicates from Sorted List
#### 题目描述

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

#### 思路
基本思路是：head.next.val == head.val ? head.next = head.next.next : head = head.next;
``` java

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        while (head.next != null){
            if(head.next.val == head.val) {
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        
        return head;
        
    }
```

但是结果不如意，只得到了最后的一个node，因为我在两值不同的前提下还是对原来head的长度进行了修改，导致了数据的丢失。

解决方法是用一个ListNode指向head，在过程中我在两值不同的前提下只改变了temphead的长度，只有在两值相同时，才改变了head的长度。

``` java

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode temphead = head;
        while (temphead.next != null){
            if(temphead.next.val == temphead.val) {
                temphead.next = temphead.next.next;
            }else{
                temphead = temphead.next;
            }
        }
        return head;
        
    }

``` 
