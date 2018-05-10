### 155. Min Stack
#### 题目描述
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

#### 思路
用普林斯顿那门算法课的linkedlist法来做这个stack:
```java

    class MinStack {

        /** initialize your data structure here. */
        
        private ListNode first = null;
        
        public void push(int x) {
            ListNode oldfirst = first;
            first = new ListNode();
            first.val = x;
            first.next = oldfirst;
        }
        
        public void pop() {
            first = first.next;
        }
        
        public Integer top() {
            if(first == null) return null;
            return first.val;
        }
        
        public Integer getMin() {
            if(first == null) return null;
            ListNode testfirst = first;
            int min = testfirst.val;
            while(testfirst != null && testfirst.next != null){
                if(testfirst.next.val <= min) min = testfirst.next.val;
                testfirst = testfirst.next;
            }
            return min;
        }
        
        private class ListNode{
            int val;
            ListNode next;
        }
        
    }

```
但是这么做的runtime好像很不如意...应该是getMin方法的锅；

### 232. Implement Queue using Stacks
#### 题目描述

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

#### 思路
就push的时候把放到第一个变成放到最后一个？
``` java

class MyQueue {
    
    Stack<Integer> queue = new Stack<Integer>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
//      把queue清空
        while(!queue.empty()){
            temp.push(queue.pop());
        }
//      将x放到queue第一个进入的位置
        queue.push(x);
//      将temp中存储的queue的数据按原来的顺序放入
        while(!temp.empty()){
            queue.push(temp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty();
    }
}

``` 
但是这个方法很慢，评论中提到了用两个stack的方法要好很多。

### 258. Add Digits
#### 题目描述

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

#### 思路
不看followup内的要求的话，其实很简单。感觉和之前做过的某条差不多。

``` java

    public int addDigits(int num) {
        while(num/10 != 0){
            int tempnum = num;
            num = 0;
            while(tempnum/10 != 0){
                num += tempnum%10;
                tempnum = tempnum/10;
            }
            num += tempnum;
        }
        return num;
    }

```
但是既不用loop也不用recursion，要怎么做呢？
评论区大佬给了一个很快的数学解法congruence formula:
The Digital Root of a number is same as the remainder when that number is divided by 9 (and this remainder will always be a single digit).
例子：
```
-----------------------------------------
[Step 1]:

438  == 40*10 +3*10 +8 ;

4+3+8 == 4*(10%9)*(10%9)+3*(10%9)+8%9= 15;

-----------------------------------------
[Step 2]:

15  == 1*10 + 5 ;
 
1+5 == 1*(10%9)+5%9= 6 ;

-----------------------------------------
[So we can see]:

ab%9%9%9==ab%9; 

just return num%9; and don't forget num==0 or num==9   

```

代码：

```java

    public int addDigits(int num) {
        if(num == 0) return num;
        else{
            if(num%9 == 0) return 9;
                else return num%9;
        }
    }

```

### 283. Move Zeroes
#### 题目描述
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

#### 思路
因为数组里有很多0，所以从左到右找到不为零的所有数字，依次排到前面，剩下的全部设为0即可。
```java

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for(int i : nums){
            if(i != 0){
                nums[pos] = i;
                pos++;
            }
        }
        while(pos < nums.length){
            nums[pos] = 0;
            pos++;
        }
    }

```
比较了一下另外的循环方式（int i = 0; i < nums.length; i++），好像这种iterator比较慢一点！

