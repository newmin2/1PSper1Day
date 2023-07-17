import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = bf.readLine().toCharArray();
        char[] s2 = bf.readLine().toCharArray();
        int[][] dp = new int[s2.length+1][s1.length+1];
        dp[0][0]=0;
        for(int i=0;i<s2.length;i++){
            for(int j=0;j<s1.length;j++){
                if(s2[i]==s1[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        int length = dp[s2.length][s1.length];
        System.out.println(length);
        
        StringBuilder sb = new StringBuilder();
        int cursorI = s2.length;
        int cursorJ = s1.length;
        while(dp[cursorI][cursorJ]>0){
            if(dp[cursorI][cursorJ]==dp[cursorI-1][cursorJ]){
                cursorI--;
            }else if(dp[cursorI][cursorJ]==dp[cursorI][cursorJ-1]){
                cursorJ--;
            }else{
                sb.append(s2[cursorI-1]);
                cursorI--;
                cursorJ--;
            }
        }
        System.out.println(sb.reverse());
    }
}