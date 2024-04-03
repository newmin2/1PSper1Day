import java.io.*;
import java.util.*;

public class Main {
    static int[] bfs(List<Integer>[] list,int n){
        Queue<Integer>q = new ArrayDeque<>();
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        q.offer(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int idx = q.poll();
            List<Integer>tmp = list[idx];
            for(int i=0;i<tmp.size();i++){
                int next = tmp.get(i);
                if(visited[next])continue;
                visited[next]=true;
                arr[next]=idx;
                q.offer(next);
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        StringBuilder sb = new StringBuilder();
        int[] arr = bfs(list,n);
        for(int i=2;i<=n;i++){
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}