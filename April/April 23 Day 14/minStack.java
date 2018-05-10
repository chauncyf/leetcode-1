
class minStack {

    /** initialize your data structure here. */
    
    private ListNode first = null;
    
    public void push(int x) {
        ListNode oldfirst = first;
        first = new ListNode();
        first.val = x;
        first.next = oldfirst;
    }
    
    public void pop() {
        first = first.next;
    }
    
    public Integer top() {
        if(first == null) return null;
        return first.val;
    }
    
    public Integer getMin() {
        if(first == null) return null;
        ListNode testfirst = first;
        int min = testfirst.val;
        while(testfirst != null && testfirst.next != null){
            if(testfirst.next.val <= min) min = testfirst.next.val;
            testfirst = testfirst.next;
        }
        return min;
    }
    
    private class ListNode{
        int val;
        ListNode next;
    }
    
}
