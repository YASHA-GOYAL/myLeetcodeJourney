class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        char[] mov = moves.toCharArray();
        int count = 0;
        int underscore= 0;
        for(int i = 0 ; i < mov.length; i++){
            if( mov[i] == 'L'){
                count--;
            }
            else if(mov[i] == 'R'){
                count++;
            }
            else{
                underscore++;
            }
           
        }
        int result= Math.abs(count) + underscore;
        return result;
    }
}