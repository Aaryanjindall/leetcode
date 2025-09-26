class Solution {
    public int totalFruit(int[] fruits) {
        int typecount = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int j = 0;
        int maxlen = 0;
        for(int i = 0 ; i < fruits.length ; i++){
            hm.put(fruits[i],hm.getOrDefault(fruits[i],0)+1);
            
            if(hm.get(fruits[i])==1){
                typecount++;
            }
            
            while(typecount > 2){
                hm.put(fruits[j],hm.get(fruits[j])-1);
                    if(hm.get(fruits[j])==0){
                        typecount--;
                    }
                j++;
                
            }
            count = i-j+1;
            
            maxlen = Math.max(maxlen,count);

            
        }
        return maxlen;
    }
}