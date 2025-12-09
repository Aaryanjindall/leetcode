class Solution {
    static class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] != x)parent[x] = find(parent[x]); // yeh h path compression
            return parent[x];
        }
        boolean union(int a , int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb)return false; // yeh already connected h 
            if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }
            else if(rank[pb] < rank[pa]){
                parent[pb] = pa;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }
    public int makeConnected(int n, int[][] conn) {
        // if(conn.length < n-1)return -1;
        DSU dsu = new DSU(n);
        int extra = 0;
        for(int []c : conn){
            int u = c[0];
            int v = c[1];
            if(!dsu.union(u,v)){
                extra++;
            }
        }
        int comp = 0;
        for(int i = 0 ; i < n ; i++){
            if(dsu.find(i) == i)comp++;
        }

        int need = comp-1;
        return (extra >= need) ? need : -1;
    }
}