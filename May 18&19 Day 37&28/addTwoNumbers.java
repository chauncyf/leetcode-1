class addTwoNumbers{
	public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = new ListNode(0);
        ListNode headres = res;
        int carry = 0;
        while(head1 != null && head2 != null){
            ListNode a = new ListNode((head1.val+head2.val+carry)%10);
            carry = (head1.val+head2.val+carry)/10;
            headres.next = a;
            headres = headres.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1 != null){
            ListNode a = new ListNode((head1.val + carry)%10);
            carry = (head1.val + carry)/10;
            headres.next = a;
            head1 = head1.next;
            headres = headres.next;
        }
        while(head2 != null){
            ListNode a = new ListNode((head2.val + carry)%10);
            carry = (head2.val + carry)/10;
            headres.next = a;
            head2 = head2.next;
            headres = headres.next;
        }
        if(carry > 0){
            ListNode tail = new ListNode(carry);
            headres.next = tail;
        }
        return res.next;
    }

// a simplified version
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = new ListNode(0);
        ListNode headres = res;
        int sum = 0;
        while(head1 != null || head2 != null){
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            ListNode a = new ListNode(sum%10);
            headres.next = a;
            headres = headres.next;
            sum = sum/10;
        }
        if(sum > 0){
            ListNode tail = new ListNode(sum);
            headres.next = tail;
        }
        return res.next;
    }
}