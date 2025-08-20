class Solution {
    public String clearStars(String s) {

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0])return b[1]-a[1];
            else{
                return a[0]-b[0];
            }
        });
        char[] charArray = s.toCharArray();
        for(int i = 0 ; i < charArray.length ; i++){
            char ch = charArray[i];

            if(ch == '*'){
                int[]small = pq.remove();
                int index = small[1];

                charArray[index] = '#';

            }
            else{
                pq.add(new int[] {ch,i});
            }
        }

        

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < charArray.length ; i++){
            char ch = charArray[i];
            if(ch == '#' || ch == '*'){
                continue;
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();


    
        
    }
}