class MyStack {
    Queue<Integer>que;

    public MyStack() {
        que = new LinkedList<>();
    }
    
    public void push(int x) {
        que.add(x);
    }
    
    public int pop() {
        int n = que.size();

        while(n-- > 1){
            int x = que.poll();
            que.add(x);
        }

        return que.poll();
    }
    
    public int top() {
        int n = que.size();
        while(n-- > 1){
            int x = que.poll();
            que.add(x);
        }

        int x = que.poll();
        que.add(x);
        return x;
    }
    
    public boolean empty() {
        return que.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */