class MinStack {
    private int[] stack;
    private int[] minStack;
    private int top;
    private int capacity = 30000; 

    public MinStack() {
        stack = new int[capacity];
        minStack = new int[capacity];
        top = -1;
    }
    
    public void push(int val) {
        top++;
        stack[top] = val;
        

        if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
    }
    
    public void pop() {
        if (top >= 0) {
            top--;
        }
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */