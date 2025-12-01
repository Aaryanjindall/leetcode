class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int ad) {
        int caprock[][] = new int [capacity.length][2];
        for(int i = 0 ; i < capacity.length ; i++){
            caprock[i][0] = capacity[i];
            caprock[i][1] = rocks[i];
        }

        Arrays.sort(caprock, (a,b) -> {
            int diffa = a[0] - a[1];
            int diffb = b[0] - b[1];
            return Integer.compare(diffa,diffb);
        });
        
        int bag = 0;
        for(int i = 0 ; i < capacity.length ; i++){
            int need = caprock[i][0] - caprock[i][1]; // kitna chahiye

            if(need == 0){      // already full
                bag++;
            }
            else if(ad >= need){   // direct fill → NO WHILE LOOP
                ad -= need;
                caprock[i][1] = caprock[i][0];
                bag++;
            }
            else{   // even 1 bag nahi fill hoga → break
                break;
            }
        } 
        return bag;   
    }
}