class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int task : tasks){
            hm.put(task,hm.getOrDefault(task,0)+1);
        }

        int round = 0;
        for(int value : hm.values()){
            if(value == 1){
                return -1;
            }
            // round += value%3;
            if(value % 3 == 0){
                round += value/3;
            }
            else{
                round += value/3 + 1;
            }

        }
        return round;
    }
}