class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lister = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length-1 ; i++){
            int currdiff = Math.abs(arr[i] - arr[i+1]);
            min = Math.min(min,currdiff);
        }
        for(int i = 0 ; i < arr.length-1 ; i++){
            if(arr[i]<arr[i+1]){
                if((arr[i+1] - arr[i]) == min){
                    list.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }

        }
        
        return list;
    }
}