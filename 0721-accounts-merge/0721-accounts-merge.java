class Solution {
    static int par[];
    static int rank[];

    public static int find(int x){
        if(par[x] == x) return x;

        return par[x] = find(par[x]);
    }
    public static void union(int x , int y){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
        }

        HashMap<String, Integer> hm = new HashMap<>();
        // mapping mail int the map
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(hm.containsKey(mail) == false){
                    hm.put(mail, i);
                }else{
                    union(i, hm.get(mail));
                }
            }
        }

        //Group emails according to ultimate parent
        ArrayList<String> mergeMail[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergeMail[i] = new ArrayList<>();
        }

        for(String mail : hm.keySet()){
            int node = find(hm.get(mail));
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i< n; i++){
            if(mergeMail[i].size() == 0) continue;

            Collections.sort(mergeMail[i]);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            //add all sorted mail
            temp.addAll(mergeMail[i]);

            ans.add(temp);
        }
        return ans;
    }
}