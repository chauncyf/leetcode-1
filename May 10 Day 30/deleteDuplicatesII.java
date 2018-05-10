 
    class deleteDuplicatesII{

        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode fake = new ListNode(-1000);
            fake.next = head;
            ListNode prevd = fake;
            ListNode posbd = head;
            while(posbd!=null){
                if(posbd.next!=null && posbd.val == posbd.next.val){
                    int duplicate = posbd.val;
                    while(posbd!=null && posbd.val == duplicate){
                        posbd = posbd.next;
                    }
                    prevd.next = posbd;
                }else{
                    prevd = posbd;
                    if(posbd!= null) posbd = posbd.next;
                }
            }
            return fake.next;
        }
        
    }