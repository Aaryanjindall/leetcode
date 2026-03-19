class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left ; i <= right ; i++){
            if(check(i)){
                list.add(i);
            }
        }
        return list;
    }
    private boolean check(int i){
        int temp = i;
        while(temp > 0){
            int last = temp%10;
            temp = temp/10;
            if(last == 0)return false;
            if(last != 0 && i % last != 0){
                return false;
            }
        }
        return true;
    }
}