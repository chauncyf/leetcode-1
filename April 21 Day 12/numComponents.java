class numComponents{

    public int numComponents(ListNode head, int[] G) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }
        int count = 0;
        
        while(head != null){
            boolean exist = false;
            while(head != null && set.contains(head.val)){
                exist = true;
                head = head.next;
            }
            if(exist) {
                count++;
            }
            if (head != null) {
                head = head.next;
            }
        }
        
        return count;
    }

}
    