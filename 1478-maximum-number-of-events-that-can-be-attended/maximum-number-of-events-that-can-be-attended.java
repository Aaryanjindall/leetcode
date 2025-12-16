class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // stores end days
        int i = 0;
        int n = events.length;
        int attend = 0;
        
        int day = events[0][0];

        while(i < n || !pq.isEmpty()){

            if(pq.isEmpty()){
                day = events[i][0];
            }

            // Add all events whose start day <= current day
            while(i < n && events[i][0] <= day){
                pq.add(events[i][1]);
                i++;
            }

            // Remove expired events
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            // Attend one event if possible
            if(!pq.isEmpty()){
                pq.poll();  // attend event with smallest end day
                attend++;
            }

            day++;
        }

        return attend;
    }
}
