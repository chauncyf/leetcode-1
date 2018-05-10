### 82. Remove Duplicates from Sorted List II
#### Problem
```text
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
```
#### Solution
我就是顺着逻辑遍历的，具体看代码中的注释。
```java
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fake = new ListNode(-1000);
        fake.next = head;
        ListNode prevd = fake; //the node before possible duplicate
        ListNode posbd = head; //possible duplicate
        //posbd一直循环到倒数第二位
        while(posbd!=null&&posbd.next!=null){
            //如果posbd的确是重复值
            if(posbd.val == posbd.next.val){
                int duplicate = posbd.val;
                //如果最后一位也是重复值，让posbd==null
                //如果最后一位不是重复值，posbd==重复值组后第一个node
                while(posbd!=null && posbd.val == duplicate){
                    posbd = posbd.next;
                }
                //删去prevd和posbd之间所有node
                prevd.next = posbd;
            //如果posbd不是重复值
            }else{
                //podbd和prevd一起后移一位
                prevd = posbd;
                posbd = posbd.next;
            }
        }
        return fake.next;
    }
```

### 69. Sqrt(x)
#### Problem
```text
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```
#### Solution

可以用计算方法课上学的牛顿法：
```java
    //牛顿法：求解f(res) = res^2-x=0这个一元二次方程
    //用y=f(res0)+f'(res0)(res-res0) = '/近似表示f(res)
    //求得res1后放入迭代
    //res(n+1)=(res(n)+a/res(n))/2
    //即res = (res + a/res)/2
    public int mySqrt(int x) {
        double res = x;
        double eps = 1e-12;
        while (Math.abs(res - x/res) > eps * res) {
            res = (res + x / res) / 2.0;
        }
        return (int)res;
    }
```

the plain binary search 2333:
```java
    //binary search
    public int mySqrt(int x) {
        if (x==0 || x == 1) return x;
        int left = 1;
        int right = x;
        while(true){
            int mid = left + (right-left)/2;
            //如果mid的平方大于x，right-;
            if(mid > x/mid) right = mid - 1;
            //如果mid的平方小于x，
            else {
                //且mid+1的平方大于x。则取mid
                if((mid+1) > x/(mid+1)) return mid;
                //且mid+1的平方也小于x。则left+
                else left = mid + 1;
            }
        }
    } 
```
### 86. Partition List
#### Problem
```text
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
```
#### Solution
分别存在两个linkedlist中，然后把他们相接就好。
需要注意的是，rightlist.next必须设为null来避免cycle!

例：5->6->1->2, x=3,最后tempright指向6, templeft指向2, we must set 6->1 to 6->null, otherwise there will be a cycle
```java
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode leftlist = new ListNode(0);
        ListNode templeft = leftlist;
        ListNode rightlist = new ListNode(0);
        ListNode tempright = rightlist;
        while(head!=null){
            if(head.val < x){
                templeft.next = head;
                templeft = head;
            }else{
                tempright.next = head;
                tempright = head;
            }
            head = head.next;
        }
        //这行一定要注意！提交的时候报错却一直找不到的原因！to avoid cycle in linked list. otherwise u will get TLE.
        tempright.next = null;
        templeft.next = rightlist.next;
        return leftlist.next;
    }
```

