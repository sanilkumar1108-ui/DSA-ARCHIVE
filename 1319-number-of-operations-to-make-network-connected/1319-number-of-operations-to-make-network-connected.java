class Solution {
    static int par[];
    static int rank[];

    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(rank[parX] == rank[parY]){
            par[parX] = parY;
            rank[parY]++;
        }else if(rank[parX] > rank[parY]){
            par[parY] = parX;
        }else{
            par[parX] = parY;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
        }

        for(int i = 0; i < connections.length; i++){
            union(connections[i][0], connections[i][1]);
        }

        int components = 0;

        for(int i = 0; i < n; i++){
            if(par[i] == i){
                components++;
            }
        }
        return components - 1;
    }
}