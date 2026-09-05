class CustomStack {

    int[]stack;
    int[]inc;
    int ptr;
    public CustomStack(int maxSize) {
        this.stack=new int[maxSize];
        this.inc=new int[maxSize];
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
        int res=inc[ptr]+stack[ptr];
        if(ptr>0){
            inc[ptr-1]+=inc[ptr];
        }
        inc[ptr]=0;
        ptr--;

        return res;
    }
    
    public void increment(int k, int val) {
       int limit=Math.min(k,ptr+1);

       if(limit>0){
        inc[limit-1]+=val;
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