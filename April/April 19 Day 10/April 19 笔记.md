### 237. Delete Node in a Linked List
#### 题目描述
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

#### 思路
很简单，把current node变成next node;
```java

    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next =  node.next.next;
        
    }

``` 
### 206. Reverse Linked List
#### 题目描述
Reverse a singly linked list.
Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
#### 思路

iteratively:

```java

    public ListNode reverseList(ListNode head) {
        
        if(head == null) return head;
        
//      事先存储下一个node
        ListNode next = head.next;
        head.next = null;
        
        while(next != null){
            
//          事先存储下一个node
            ListNode temp = next.next;
            next.next = head;
            head = next; 
            // next = next.next;  //这里的next发生改变了，指向的不再是下一个而是前一个，所以上面得加一个临时变量存储
            next = temp;
            
        }
        return head;
    }

```

recursively（思路基本一样）:

```java

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode next = head.next;
        head.next = null;
        return recursive(head, next);
    }
    
    public ListNode recursive(ListNode head, ListNode next){
        if(next == null) return head;
        ListNode temp = next.next;
        next.next = head;
        head = next;
        next = temp;
        return recursive(head, next);
    }

```
### 21. Merge Two Sorted Lists
#### 题目描述
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

#### 思路

iteratively:

```java
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode temphead = new ListNode(0);
        ListNode current = temphead;
        
        while(l1 != null && l2 != null){
            
            if(l1.val >= l2.val){
                    current.next = l2;
                    current = l2;
                    l2 = l2.next;
            }else{
                    current.next = l1;
                    current = l1;
                    l1 = l1.next;
            }
            
        }
        
        if(l1 == null && l2 != null) {
            current.next = l2;
        }
        
        if(l2 == null && l1 != null) {
            current.next = l1;
        }
    
        return temphead.next;
        
    }
``` 

recursively:

```java
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        
        if(l2 == null) return l1;
        
        if(l1.val >= l2.val){
            
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
             
        }else{
            
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
            
        }
        
    }
```
