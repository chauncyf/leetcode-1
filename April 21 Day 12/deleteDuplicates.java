 class deleteDuplicates{

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        while (head.next != null){
            if(head.next.val == head.val) {
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        
        return head;
        
    }
    
}
