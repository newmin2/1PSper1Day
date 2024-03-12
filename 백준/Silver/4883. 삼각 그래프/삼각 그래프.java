import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t=1;
        int[][] memo = new int[2][3];

        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(bf.readLine());
            if(n==0)break;
            int[][] arr = new int[n][3];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<3;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int flag = 0;
            memo[flag][1]=memo[flag][0]=arr[0][1];
            memo[flag][2]=Math.min(arr[0][1],arr[0][1]+arr[0][2]);
            for(int i=1;i<n;i++){
                memo[flag^1][0]=arr[i][0]+Math.min(memo[flag][0],memo[flag][1]);
                memo[flag^1][1]=arr[i][1]+Math.min(memo[flag^1][0],
                        Math.min(Math.min(memo[flag][0],memo[flag][1]),memo[flag][2]));
                memo[flag^1][2]=arr[i][2]+Math.min(memo[flag^1][1],Math.min(memo[flag][1],memo[flag][2]));
                flag^=1;
            }
            sb.append(t+++". ").append(memo[flag][1]).append('\n');
        }
        System.out.println(sb);
    }
}