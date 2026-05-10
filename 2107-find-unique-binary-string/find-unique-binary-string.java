class Solution {
    StringBuilder sb = new StringBuilder();
    public String findDifferentBinaryString(String[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums[0].length();
        bt(0,n,list);
        String ans = "";
        for(int i = 0 ; i < list.size() ; i++){
            // System.out.println(list.get(i));
            boolean found = false;
            for(int j = 0 ; j < nums.length ; j++){
                if(list.get(i).equals(nums[j])){
                    found = true;
                }
            }
            if(found == false){
                ans = list.get(i);
                return ans;
            }
        }
        return "";
    }
    private void bt(int curr , int n , List<String> list){
        if(curr == n){
            list.add(new StringBuilder(sb).toString());
            return;
        }
        sb.append('0');
        bt(curr+1,n,list);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('1');
        bt(curr+1,n,list);
        sb.deleteCharAt(sb.length() - 1);
    }
}