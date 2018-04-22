class oddEvenLinkedlist{

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
    
}