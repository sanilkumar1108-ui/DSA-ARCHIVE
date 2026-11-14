class Solution {
    class Pair{
        String first;
        int second;
        public Pair(String f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < wordList.size(); i++){
            hs.add(wordList.get(i));
        }
        if(!hs.contains(endWord)) return 0;

        q.add(new Pair(beginWord, 1));
        hs.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.remove();
            String word = curr.first;
            int steps = curr.second;

            if(word.equals(endWord)) return steps;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char arr[] = word.toCharArray();
                    arr[i] = ch;
                    String replaceWord = new String(arr);
                    if(hs.contains(replaceWord)){
                        hs.remove(replaceWord);
                        q.add(new Pair(replaceWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}