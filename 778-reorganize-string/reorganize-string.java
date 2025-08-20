class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int f : freq){
            if(f > (n + 1) / 2){
                return "";
            }
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] > 0){
                pq.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            int[] first = pq.poll();
            int[] second = pq.poll();

            sb.append((char)(first[0] + 'a'));
            sb.append((char)(second[0] + 'a'));

            first[1]--;
            second[1]--;

            if(first[1] > 0){
            pq.add(first);
            }
            
            if(second[1] > 0){
                pq.add(second);
            }
        }

        if(pq.size() > 0){
    int[] last = pq.poll();
    sb.append((char)(last[0] + 'a'));
}

return sb.toString();


    }
}