class Solution {
public:
    int tribonacci(int n) {
        if(n==0){
            return 0;
        }else if ( n == 1|| n== 2){
            return 1;
        }else {
            long long a = 0, b = 1, c = 1;

            for(int i=1; i<=n; i++){

                long long d = a+b+c;
                a = b;
                b = c;
                c = d;
            }
            return a;
        }
        
    }
};