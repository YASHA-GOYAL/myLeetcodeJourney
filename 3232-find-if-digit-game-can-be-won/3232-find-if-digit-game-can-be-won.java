class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleSum = 0;
        int doubleSum = 0;

        for(int a : nums){
            if( a < 10){
                singleSum = singleSum + a;
            }
            else{
                doubleSum = doubleSum + a;
            }
        }
        return singleSum != doubleSum;
    }
}