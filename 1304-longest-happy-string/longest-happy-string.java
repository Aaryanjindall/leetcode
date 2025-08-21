class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int []> pq = new PriorityQueue<>((x,y) -> y[1] - x[1]);
        if(a > 0){
            pq.add(new int[]{'a',a});
        }
        if(b > 0){
            pq.add(new int[]{'b',b});
        }
        if(c > 0){
            pq.add(new int[]{'c',c});
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int [] ans = pq.poll();
            int freq = ans[1];
            char ch = (char)ans[0];

            int len = sb.length();
            if(len>=2 && sb.charAt(len-1) == ch && sb.charAt(len-2) == ch){
                if (pq.isEmpty()) {
                    // If no other characters are available, we can't add anything
                    break;
                }
                int []ans2 = pq.poll();
                int freq2 = ans2[1];
                char ch2 = (char)ans2[0];
                sb.append(ch2);
                freq2--;
                if(freq2 > 0){
                    pq.add(new int []{ch2 , freq2});
                }
            }
            sb.append(ch);
            freq--;
            if(freq > 0){
                pq.add(new int []{ch , freq});
            }


        }

        return sb.toString();

    }
}