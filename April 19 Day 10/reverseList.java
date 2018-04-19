 class reverseList{

    public ListNode reverseListI(ListNode head) {
        
        if(head == null) return head;
        
//      事先存储下一个node
        ListNode next = head.next;
        head.next = null;
        
        while(next != null){
            
//          事先存储下一个node
            ListNode temp = next.next;
            next.next = head;
            head = next; 
            // next = next.next;  //这里的next发生改变了，指向的不再是下一个而是前一个，所以上面得加一个临时变量存储
            next = temp;
            
        }
        return head;
    }

    public ListNode reverseListII(ListNode head) {
        if(head == null) return head;
        ListNode next = head.next;
        head.next = null;
        return recursive(head, next);
    }
    
    public ListNode recursive(ListNode head, ListNode next){
        if(next == null) return head;
        ListNode temp = next.next;
        next.next = head;
        head = next;
        next = temp;
        return recursive(head, next);
    }
 } 
