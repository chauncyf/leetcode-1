class removeNthFromEnd{
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        //注意特殊情况！
        //第一次写的时候没看到，结果报错了。
        //当linkedlist和n的长度一致时，直接删去第一个node。
        //因为和下面的算法比，fast和slow多进了一格，应该删除的不再是slow.next而是slow本身
        if(fast == null) return head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
        
    }
    
}