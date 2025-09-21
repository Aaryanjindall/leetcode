class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int units = 0;
        for(int i = 0 ; i < boxTypes.length ; i++){
            int boxnum = boxTypes[i][0];
            int boxunit = boxTypes[i][1];

            if(truckSize >= boxnum){
                units += boxnum * boxunit;
                truckSize -= boxnum;
                
            }
            else{
                units += truckSize*boxunit;
                truckSize = 0;
                break;
            }


        }

        return units;
    }
}