class swapNodesInPairs{
	
	public ListNode swapPairsI(ListNode head) {
        
        if(head == null) return null;
        
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp = fake;
        
        while(right != null){
            ListNode temp1 = right.next;
            left.next = temp1;
            right.next = left;
            temp.next = right;
            temp = left;
            left = temp.next;
            if(left != null) right = left.next;
            else right = null;
        }
        
        return fake.next;
    }

    public ListNode swapPairsII(ListNode head) {
        
        if ((head == null)||(head.next == null))
            return head;
        ListNode left = head;
        ListNode right = head.next;
        ListNode temp = swapPairs(head.next.next);
        left.next = temp;
        right.next = left;
        head = right;
        return head;
        
    }
    
}