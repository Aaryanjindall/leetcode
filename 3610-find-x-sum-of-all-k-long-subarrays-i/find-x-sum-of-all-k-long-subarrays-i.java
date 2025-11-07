class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int j = 0;
        int n = nums.length;
        int arr[] = new int[n-k+1];
        int idx = 0;

        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            if((i-j+1)==k){
                int sum = 0;
                PriorityQueue<Map.Entry<Integer,Integer>> pq =
    new PriorityQueue<>(
        (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return b.getKey() - a.getKey();
        }
    );
                for(Map.Entry<Integer,Integer> e : hm.entrySet()){
                    pq.add(e);
                }
                for(int l=0 ; l < x && (!pq.isEmpty()) ; l++){
                    Map.Entry<Integer,Integer> m = pq.poll();
                    sum += m.getValue()*m.getKey();
                    
                }
                arr[idx++] = sum;
                hm.put(nums[j],hm.get(nums[j])-1);
                if(hm.get(nums[j])== 0){
                    hm.remove(nums[j]);
                }
                j++;
            }
            
                
            
        }

        return arr;

       
    }
}