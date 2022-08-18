import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int a;
    static int b;
    static int cnt;
    static int ans;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(bf.readLine());
        arr= new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to]=arr[to][from]=1;
        }
        dfs(a,b,cnt);
        if(ans==0)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
    static void dfs(int a, int b, int cnt){
        if(a==b){
            ans=cnt;
        return;}
        visited[a]=true;
        for(int i=0;i<=n;i++){
            if(!visited[i]&&arr[a][i]==1)
                dfs(i,b,cnt+1);
        }
    }
}
