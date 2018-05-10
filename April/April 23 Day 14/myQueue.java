class myQueue {
    
    Stack<Integer> queue = new Stack<Integer>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
//      把queue清空
        while(!queue.empty()){
            temp.push(queue.pop());
        }
//      将x放到queue第一个进入的位置
        queue.push(x);
//      将temp中存储的queue的数据按原来的顺序放入
        while(!temp.empty()){
            queue.push(temp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty();
    }
}