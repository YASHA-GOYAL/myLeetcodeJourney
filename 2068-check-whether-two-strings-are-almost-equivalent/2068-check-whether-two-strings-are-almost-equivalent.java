class Solution {
    // aabdf
    public boolean checkAlmostEquivalent(String word1, String word2) {
       int[] arr = new int[26];
       for(char c : word1.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            arr[c - 'a']--;
        }
        for(int a : arr){
            if(a > 3 || a < -3){
                return false;
            }
        }
        return true;

    }
}