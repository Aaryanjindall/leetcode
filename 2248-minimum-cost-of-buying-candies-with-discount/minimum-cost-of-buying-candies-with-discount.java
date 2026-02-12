import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int cos = 0;
        int i = cost.length - 1;

        while (i >= 0) {
            cos += cost[i];      // sabse mehenga
            if (i - 1 >= 0) {
                cos += cost[i - 1];   // second mehenga
            }
            // i-2 free hai (agar exist karta hai)

            i -= 3;   // next group
        }

        return cos;
    }
}
