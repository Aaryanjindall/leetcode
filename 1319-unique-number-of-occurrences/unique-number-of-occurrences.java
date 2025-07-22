class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int occ[] = new int [2001];
        for(int num : arr){
            occ[num + 1000]++;
        }
        HashSet<Integer> st = new HashSet<>();
        for(int i : occ){
            if(!st.add(i) && i != 0){
                return false;

            }
        }
        return true;



    }
}