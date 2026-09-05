class CustomStack {

    int[]stack;
    int ptr;
    public CustomStack(int maxSize) {
        this.stack=new int[maxSize];
        ptr=-1;
    }
    
    public void push(int x) {
        if(ptr==stack.length-1){
            return;
        }
        ptr++;
        stack[ptr]=x;
    }
    
    public int pop() {
        if(ptr==-1){
            return -1;
        }
        int popped=stack[ptr];
        ptr--;
        return popped;
    }
    
    public void increment(int k, int val) {
        if(stack.length<k){
            for(int i=0;i<=ptr;i++){
                stack[i]=stack[i]+val;
            }
        }else{
         for(int i=0;i<k;i++){
            stack[i]=stack[i]+val;
         }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */