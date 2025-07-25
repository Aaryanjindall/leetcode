import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer>hm = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i<n ; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        Set<Integer> keys = hm.keySet();
        for(Integer k : keys){
            if(hm.get(k) > n/3){
                list.add(k);
            }

        }
        return list;

        
    }
}