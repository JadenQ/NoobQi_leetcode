class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int g_count = 0;
        if(g.length == 0 || s.length == 0){return 0;}
        
        for(int i = 0; i < s.length; i++){
            if(g.length == g_count) {return count;}
            else if(g[g_count] > s[i]){continue;}
            else{
                count += 1;
                g_count += 1;
            }
        }
        return count;
    }
}