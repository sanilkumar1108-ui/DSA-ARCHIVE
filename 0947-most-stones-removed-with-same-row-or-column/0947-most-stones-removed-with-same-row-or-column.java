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
        }
        if(rank[parX] > rank[parY]){
            par[parY] = parX;
        }else{
            par[parX] = parY;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        for(int i = 0; i < n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        par = new int[maxRow + maxCol + 2];
        rank = new int[maxRow + maxCol + 2];
        for(int i = 0; i < par.length; i++){
            par[i] = i;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++){
            int nodeRow = stones[i][0];// par me 0 to maxRow
            int nodeCol = stones[i][1] + maxRow + 1;//maxrow to end

            union(nodeRow, nodeCol);
            hm.put(nodeRow, 1);
            hm.put(nodeCol, 1);
        }
        int count = 0;
        for(Integer node: hm.keySet()){
            if(find(node) == node){
                count++;
            }
        }
        return n - count;
    }
}