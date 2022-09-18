import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int n,ans,max;
    static void dfs(int i,int a, int cnt){
        if(visited[a]) {
            max=Math.max(cnt,max);
            if(max==cnt)
                ans=i;
            return;
        }
        visited[a]=true;
        dfs(i,arr[a], cnt + 1);
        visited[a]=false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        for(int i=n; i>=1; i--){
            dfs(i,i,0);
        }
        System.out.println(ans);
    }
}
