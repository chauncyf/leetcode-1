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

