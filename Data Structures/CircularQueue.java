class MyCircularQueue {
    private int[] q;
    private int f, r, size;

    public MyCircularQueue(int k) {
        q = new int[k];
        size = k;
        f = -1;
        r = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        if (isEmpty()) {
            f = 0;
            r = 0;
        } else {
            r = (r + 1) % size;
        }
        
        q[r] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (f == r) {
            f = -1;
            r = -1;
        } else {
            f = (f + 1) % size;
        }
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : q[f];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : q[r];
    }
    
    public boolean isEmpty() {
        return f == -1;
    }
    
    public boolean isFull() {
        return (r + 1) % size == f;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */