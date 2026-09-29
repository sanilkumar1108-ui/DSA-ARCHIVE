class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s : sentences){
            String[] res = s.split(" ");
            max = Math.max(max, res.length);
        }
        return max;
    }
}