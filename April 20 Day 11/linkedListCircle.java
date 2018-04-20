class linkedListCycle{
	
	public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        while(head != null && head.next!=null){
            if(head.next == temp) return true;
            head = head.next;
        }
        return false;
    }
}


