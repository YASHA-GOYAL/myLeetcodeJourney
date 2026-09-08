class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // 5 0 1 4
        int max = 0;
        int min = nums[0];
        int minIndex = 0;
        for( int j = 1; j < nums.length; j++){
                if(nums[j] <= min){
                    min = nums[j];
                    minIndex = j;
                }
            }
        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] > max){
                max = nums[i];
            }
            if(minIndex != i){        
                int instabilityScore = max - min;
                if( instabilityScore <= k) return i;
                
            }else{
                int instabilityScore = max - min;
                if( instabilityScore <= k) return i;
                if(i < nums.length - 1){   
                    min = nums[i+1];
                    minIndex = i+1;
                }
                for( int j = i+1; j < nums.length; j++){
                    if(nums[j] < min){
                        min = nums[j];
                        minIndex = j;
                    }
                }
            }          
        }
        return -1;
    }
}