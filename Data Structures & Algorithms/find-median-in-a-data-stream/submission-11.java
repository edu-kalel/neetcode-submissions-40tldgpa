class MedianFinder {

    Queue<Integer> minor;
    Queue<Integer> bigger;

    public MedianFinder() {
        minor = new PriorityQueue<>((a,b) -> b-a);
        bigger = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        minor.add(num);
        if(!bigger.isEmpty() && minor.peek()>bigger.peek()){
            bigger.add(minor.poll());
        }
        if(bigger.size()>minor.size()){
            minor.add(bigger.poll());
        }
        if(minor.size()-bigger.size()>1){
            bigger.add(minor.poll());
        }
        // System.out.println(bigger);
        // balance at the end
    }
    
    public double findMedian() {
        if(minor.size()==bigger.size()){
            return (double) (minor.peek()+bigger.peek())/2;
        }
        else{
            return minor.peek();
        }
    }
}
