class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int result[] = new int[nums.length - k + 1];
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        int j = 0;
        int a = 0;
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            if(i-a+1 > k){
                hm.put(nums[a],hm.get(nums[a])-1);
                if(hm.get(nums[a]) == 0){
                    hm.remove(nums[a]);
                }
                a++;
            }
            if(i-a+1 == k){
                int b = cal(hm,x);
                result[j] = (b<0)?b:0;
                j++;
            }
        }

        return result;
    }
    private int cal(TreeMap<Integer,Integer> hm , int key){
        int count = 0;
        for(int i : hm.keySet()){
            count += hm.get(i);
            if(count >= key){
                return i;
            }

        }
        return 0;

    }
}