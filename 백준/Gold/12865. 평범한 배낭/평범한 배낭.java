import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for(int j=K;j>=0;j--){
                if(weight>j) continue;
                dp[j]=Math.max(dp[j],dp[j-weight]+value);
            }
        }
        System.out.println(dp[K]);
    }
}