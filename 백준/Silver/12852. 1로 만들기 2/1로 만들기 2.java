import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean divide(int a,int b) {
        return a % b == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //입력 끝
        int[] dp = new int[1000001];
        int[] memo = new int[1000001];
        for(int i=2;i<1000001;i++){
            int min;
            if(divide(i,3)){
                if(divide(i,2)){
                    min = Math.min(Math.min(dp[i/3],dp[i/2]),dp[i-1]);
                    if(min==dp[i/3]){
                        dp[i]=dp[i/3]+1;
                        memo[i]=i/3;
                    }
                    else if(min==dp[i/2]) {
                        dp[i]=dp[i/2]+1;
                        memo[i]=i/2;
                    }
                    else {
                        dp[i]=dp[i-1]+1;
                        memo[i]=i-1;
                    }
                }else {
                    min = Math.min(dp[i / 3], dp[i - 1]);
                    if (min == dp[i / 3]) {
                        dp[i] = dp[i / 3] + 1;
                        memo[i] = i / 3;
                    } else {
                        dp[i] = dp[i - 1] + 1;
                        memo[i] = i - 1;
                    }
                }
            }else if(divide(i,2)){
                min = Math.min(dp[i/2],dp[i-1]);
                if(min==dp[i/2]){
                    dp[i]=dp[i/2]+1;
                    memo[i]=i/2;
                }
                else {
                    dp[i]=dp[i-1]+1;
                    memo[i]=i-1;
                }
            }else{
                dp[i]=dp[i-1]+1;
                memo[i]=i-1;
            }
        }
        System.out.println(dp[n]);
        System.out.print(n+" ");
        while(memo[n]!=0){
            System.out.print(memo[n]+" ");
            n=memo[n];
        }
    }
}