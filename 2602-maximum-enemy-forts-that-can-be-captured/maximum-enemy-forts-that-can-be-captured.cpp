class Solution {
public:
    int captureForts(vector<int>& f) {
        // 1,0,0,-1,0,0,0,0,1

        int ans=0;
        for(int i=0; i<f.size(); i++){
            int count=0;
            if(f[i] != 0){
                for(int j=i+1; j<f.size(); j++){
                    // -1 j != i  ->>> -1 and 1
                    if(f[j] == 0) count++; // 1 0 0 -1 0 0 00 0 1
                    else {
                        if(f[i] != f[j]) 
                        ans = max(ans,count);
                        break;
                    } 
                }
            }
        }
        return ans;
    }
};