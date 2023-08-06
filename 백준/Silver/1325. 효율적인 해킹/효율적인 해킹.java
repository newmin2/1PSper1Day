import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void dfs(int start,int ori){
        for(int i:list[start]){
            if(visited[i])continue;
            visited[i]=true;
            cnt[ori]++;
            dfs(i,ori);
        }
    }
    static List<Integer>[] list;
    static int[] cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list= new ArrayList[n+1];
        cnt = new int[n+1];
        for(int i=1;i<=n;i++){
            list[i]= new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st =new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
        int max=-1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            visited= new boolean[n+1];
            visited[i]=true;
            dfs(i,i);
            max=Math.max(max,cnt[i]);
        }
        for(int i=1;i<=n;i++){
            if(cnt[i]==max){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
