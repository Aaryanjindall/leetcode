class Solution {
    int val[] = {8,4,2,1,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        bt(list,0,0,0,turnedOn);
        return list;
    }
    private void bt(List<String> list , int idx ,int hour,int min , int turn){
        if (hour > 11 || min > 59) return;
        if(turn  == 0){
            list.add(hour + ":" + (min < 10 ? "0" : "") + min);
            return;
        }
        if(idx == 10 || turn < 0)return;
        if(idx < 4){
            bt(list,idx+1,hour+val[idx],min,turn-1);
        }
        else{
            bt(list,idx+1,hour,min+val[idx],turn-1);
        }
        bt(list,idx+1,hour,min,turn);
        

    }
}