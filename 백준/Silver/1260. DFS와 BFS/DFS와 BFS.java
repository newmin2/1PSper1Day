import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer>q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to]=graph[to][from]=1;
        }
        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(sb);

    }
    static void dfs(int v){
        visited[v]=true;
        sb.append(v+ " ");

        for(int i=0; i<=n ;i++){
            if(!visited[i]&&graph[v][i]==1)
                dfs(i);
        }
    }
    static void bfs(int v){
        q.add(v);
        visited[v]=true;

        while(!q.isEmpty()){
            v= q.poll();
            sb.append(v+" ");
            for(int i=0; i<=n; i++){
                if(!visited[i]&&graph[v][i]==1){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}
