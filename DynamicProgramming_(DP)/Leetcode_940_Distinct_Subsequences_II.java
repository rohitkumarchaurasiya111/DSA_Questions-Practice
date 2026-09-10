
/**
 * Leetcode_940_Distinct_Subsequences_II
 */
public class Leetcode_940_Distinct_Subsequences_II {
    public static int distinctSubseqII(String s) {
        //If i have a - " ", "a"
        // ab - " ", " a" + "b", "ab"
        //it means if new character is introduced it is added to all the subsequences of old characters
        // aba - " ", " a" , "b", "ab"  + "a", "aa", "ba", "aba"
        //if duplicate characters is encountered then duplicate subsequences gets generated and these no. of duplicates = old sequences where that character is at the end
        //In above example duplicate character is a and in old subsequence a is at end in one place so there is one duplicate

        int MOD = 1000000007;

        //Using the above intution we need to maintain the old subsequence number and no. of each characters coming at the end 
        int[] oldSubsequenceCount = new int[s.length()];
        int[] lastCharacterCount = new int[26];                             //as only 26 characters can be there in the string

        oldSubsequenceCount[0] = 2;                                     //if there is only one character, it's count is 2 always
        lastCharacterCount[s.charAt(0) - 'a'] = 1;               //increasing the last count of that first character as it will be in the last of 1 subsequence
        

        for (int i = 1; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            oldSubsequenceCount[i] = ((2 * oldSubsequenceCount[i-1])%MOD - lastCharacterCount[ch] + MOD)%MOD;       //Done so that our answer is not negative and always less than MOD Value

            lastCharacterCount[ch] = oldSubsequenceCount[i-1];
        }

        if(oldSubsequenceCount[s.length()-1] > 0){
            return oldSubsequenceCount[s.length()-1] - 1;           //Decreasing by 1 as we are not including empty string
        }
        //If value is coming less than 0 then add MOD
        return oldSubsequenceCount[s.length()-1] - 1 + MOD;  
    }
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("yezruvnatuipjeohsymapyxgfeczkevoxipckunlqjauvllfpwezhlzpbkfqazhexabomnlxkmoufneninbxxguuktvupmpfspwxiouwlfalexmluwcsbeqrzkivrphtpcoxqsueuxsalopbsgkzaibkpfmsztkwommkvgjjdvvggnvtlwrllcafhfocprnrzfoyehqhrvhpbbpxpsvomdpmksojckgkgkycoynbldkbnrlujegxotgmeyknpmpgajbgwmfftuphfzrywarqkpkfnwtzgdkdcyvwkqawwyjuskpvqomfchnlojmeltlwvqomucipcwxkgsktjxpwhujaexhejeflpctmjpuguslmzvpykbldcbxqnwgycpfccgeychkxfopixijeypzyryglutxweffyrqtkfrqlhtjweodttchnugybsmacpgperznunffrdavyqgilqlplebbkdopyyxcoamfxhpmdyrtutfxsejkwiyvdwggyhgsdpfxpznrccwdupfzlubkhppmasdbqfzttbhfismeamenyukzqoupbzxashwuvfkmkosgevcjnlpfgxgzumktsexvwhylhiupwfwyxotwnxodttsrifgzkkedurayjgxlhxjzlxikcgerptpufocymfrkyayvklsalgmtifpiczwnozmgowzchjiop"));
    }

}