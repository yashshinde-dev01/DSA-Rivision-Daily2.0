class MinStack {
    int ptr=-1;
    int[] stack = new int[10000000];

    public MinStack() {
    }
    
    public void push(int value) {
         if (ptr == stack.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        ptr++;
        stack[ptr]=value;
    }
    
    public void pop() {
         if (ptr == -1) {
            throw new RuntimeException("Stack Underflow");
        }
        ptr--;
    }
    
    public int top() {
         if (ptr == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[ptr];
    }
    
    public int getMin() {
         if (ptr == -1) {
            throw new RuntimeException("Stack is empty");
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=ptr;i++){
            if(stack[i]<min){
                min=stack[i];
            }
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */