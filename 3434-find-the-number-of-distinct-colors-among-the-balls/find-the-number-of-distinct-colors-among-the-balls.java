class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        HashMap<Integer,Integer> ballcolor = new HashMap<>();
        HashMap<Integer,Integer> colorcount = new HashMap<>();
        for(int i = 0 ; i < queries.length ; i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballcolor.containsKey(ball)){
                int oldcolor = ballcolor.get(ball);
                colorcount.put(oldcolor , colorcount.get(oldcolor)-1);
                if(colorcount.get(oldcolor) == 0){
                    colorcount.remove(oldcolor);
                }
            }
            ballcolor.put(ball,color);
            colorcount.put(color, colorcount.getOrDefault(color, 0) + 1);
            result[i] = colorcount.size();

        }
        return result;


    }
}