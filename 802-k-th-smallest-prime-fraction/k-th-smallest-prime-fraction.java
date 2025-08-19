class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare((double)b[0] / b[1], (double)a[0] / a[1]));      
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                pq.add(new int[]{arr[i], arr[j]});
                if(pq.size()>k) {
            pq.remove(); 
        }
                
            }
        }
        

        return pq.peek();
    
    }
}