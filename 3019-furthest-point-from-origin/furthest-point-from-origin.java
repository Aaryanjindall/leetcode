class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        // int ans = 0;
        // for(int i = 0 ; i < moves.length() ; i++){
        //     if(moves.charAt(i) == 'L' || moves.charAt(i) == '_'){
        //         ans -= 1;
        //     }
        //     else {
        //         ans += 1;
        //     }
        // }
        // return Math.abs(ans);
        int l = 0;
        int r = 0;
        int sp = 0;
        int ans = 0;
        int length = moves.length();
        for(int i= 0 ; i < moves.length() ; i++){
            if(moves.charAt(i) == 'L'){
                l++;
            }
            else if(moves.charAt(i) == 'R'){
                r++;
            }
            else{
                sp++;
            }
        }
        if(l>r){
            l += sp;
        }
        else if(r>l){
            r += sp;
        }
        else{
            l += sp; 
        }
        return Math.abs(l-r);

    }
}