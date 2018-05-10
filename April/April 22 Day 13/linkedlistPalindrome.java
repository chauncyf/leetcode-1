class linkedlistPalindrome{
	
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

}