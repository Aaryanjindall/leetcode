class Solution {
    public List<Integer> partitionLabels(String s){
        int freq[] = new int[26];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i)-'a'] = i;
        }
        int st = 0;
        int e = 0;
        for(int i = 0 ; i < s.length() ; i++){
            e = Math.max(e,freq[s.charAt(i)-'a']);
            if(i == e){
                list.add(e-st+1);
                st = i+1;
            }
            
        }
        // for(int i : freq){
        //     list.add(i);
        // }

        return list;

    }
}