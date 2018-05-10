class mergeTwoLists{

    public ListNode mergeTwoListsI(ListNode l1, ListNode l2) {
        
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

    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        
        if(l2 == null) return l1;
        
        if(l1.val >= l2.val){
            
            l2.next = mergeTwoListsII(l1, l2.next);
            return l2;
             
        }else{
            
            l1.next = mergeTwoListsII(l1.next, l2);
            return l1;
            
        }
        
    }
}