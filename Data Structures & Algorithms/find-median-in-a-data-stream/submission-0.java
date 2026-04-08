class MedianFinder {
    PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minpq = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxpq.isEmpty() || num<=maxpq.peek()){
            maxpq.add(num);
        }
        else{
            minpq.add(num);
        }
        int sizemx = maxpq.size();
        int sizemn = minpq.size();
        if(sizemx>sizemn+1){
            minpq.add(maxpq.poll()); 
        }
        else if(sizemn>sizemx)
            maxpq.add(minpq.poll());    
    }
    
    public double findMedian() {
        int sizemx = maxpq.size();
        int sizemn = minpq.size();
        double ans;
        if(sizemx==sizemn){
            System.out.println("Minpq"+minpq.peek());
            System.out.println("Maxpq"+maxpq.peek());
            return (minpq.peek()+ maxpq.peek())/2.0;
        }  
        else if(sizemx>sizemn){
            ans = maxpq.peek();
        }
        else ans = minpq.peek();
        return ans;
    }
}
