import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n,min;
    static void food(int s, int b, int depth){
        if(depth==n){
            if(s!=1&&b!=0)
                min=Math.min(Math.abs(s-b),min);
            return;
        }
        food(s*arr[depth][0], b+arr[depth][1], depth+1);
        food(s,b, depth + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        min=Integer.MAX_VALUE;
        food(1,0,0);
        System.out.println(min);

    }
}
