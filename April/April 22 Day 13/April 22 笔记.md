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

