### 2. Add Two Numbers
#### Problem
```text
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```
#### Solution
我就用了最呆的方法，相当于完全新建了一个linkedlist，只使用原本两个linkedlist中的值进行计算，并不更改其原本的数字。
```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = new ListNode(0);
        ListNode headres = res;
        int carry = 0;
        while(head1 != null && head2 != null){
            ListNode a = new ListNode((head1.val+head2.val+carry)%10);
            carry = (head1.val+head2.val+carry)/10;
            headres.next = a;
            headres = headres.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1 != null){
            ListNode a = new ListNode((head1.val + carry)%10);
            carry = (head1.val + carry)/10;
            headres.next = a;
            head1 = head1.next;
            headres = headres.next;
        }
        while(head2 != null){
            ListNode a = new ListNode((head2.val + carry)%10);
            carry = (head2.val + carry)/10;
            headres.next = a;
            head2 = head2.next;
            headres = headres.next;
        }
        if(carry > 0){
            ListNode tail = new ListNode(carry);
            headres.next = tail;
        }
        return res.next;
    }
```
参考更简洁的一个版本，改成如下：
```java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = new ListNode(0);
        ListNode headres = res;
        int sum = 0;
        while(head1 != null || head2 != null){
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            ListNode a = new ListNode(sum%10);
            headres.next = a;
            headres = headres.next;
            sum = sum/10;
        }
        if(sum > 0){
            ListNode tail = new ListNode(sum);
            headres.next = tail;
        }
        return res.next;
    }
```

### 26. Remove Duplicates from Sorted Array
#### Problem
```text
iven a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```
#### Solution
记录不重复的数字数为index，初始化值为1。它同时代表了下一个non-duplicate应该放入的位置。0位即nums的第一个数字，在任何情况下都不需要改变，所以index的初始值为1。

从nums中的第二个数字开始检验，如果该数字与上个数字不同，则放入nums[index]，否则不进行任何操作。

```java
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
```


