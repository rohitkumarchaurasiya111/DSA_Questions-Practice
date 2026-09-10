class Leetcode_115{
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        // System.out.println(numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
    }

    //Leetcode - 115. Distinct Subsequences
    //Given two strings s and t, return the number of distinct subsequences of s which equals t.
    //      Input: s = "rabbbit", t = "rabbit"
    //      Output: 3


    //Recursive Approach
    public static int numDistinct(String s, String t) {
        //we can use the below dp table to optimize the Time complexity
        //int[][] dp = new int[s.length()][t.length()];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        return recursive(s, 0, t, 0);
    }
    public static  int recursive(String s, int i, String t, int j){
        if(j >= t.length()){
            return 1;
        }
        if(i >= s.length()){
            return 0;
        }
        int count = 0;
        //Not Choose
        count += recursive(s, i+1, t, j);
        //Choose only if characters are same
        if(s.charAt(i) == (t.charAt(j)))
            count += recursive(s, i+1, t, j+1);
        
        return count;
    }
}