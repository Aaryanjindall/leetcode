class Solution {
    public int[] sortByBits(int[] arr) {
        int [][] pair = new int [arr.length][2];
        for(int i = 0 ; i < arr.length ; i++){
            int k = arr[i];
            int count = 0;
            if(k == 0){
                pair[i][0] = 0;
                pair[i][1] = 0;
            }
            for (int bit = 0; bit < 32; bit++) {
                if ((k & (1 << bit)) != 0) {
                    count++;
                }
            }
            pair[i][0] = arr[i];
            pair[i][1] = count;
        }

        Arrays.sort(pair,(a,b) -> {
    if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
    return Integer.compare(a[1], b[1]);
});

        int res [] = new int [arr.length];
        for(int j = 0 ; j < arr.length ; j++){
            res[j] = pair[j][0];
        }
        return res;

    }
}