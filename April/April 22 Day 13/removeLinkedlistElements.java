class removeLinkedlistElements{

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

}