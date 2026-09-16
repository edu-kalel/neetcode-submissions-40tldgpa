class MedianFinder {

    // attributes
    // heaps, max & min
    private Queue<Integer> smallHeap; //max heap, we need the max
    private Queue<Integer> largeHeap; //min heap, u get it

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b-a);  // max . 5-2=3
        largeHeap = new PriorityQueue<>((a,b) -> a-b);  // min . 2-5=-3
    }
    
    public void addNum(int num) {
        smallHeap.add(num); //always adding to small heap, just bc
        if(
            smallHeap.size() - largeHeap.size() > 1 //if unbalanced
            ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()     //small is bigger than large
        ){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size()-smallHeap.size() > 1){  //if unbalanced
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()){       //even qty
            return (double) (smallHeap.peek()+largeHeap.peek())/2;
        } else if(smallHeap.size() > largeHeap.size()){ //odd
            return (double) smallHeap.peek();
        } else{
            return (double) largeHeap.peek();
        }
    }
}
