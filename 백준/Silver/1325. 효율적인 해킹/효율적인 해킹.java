import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static List<Integer>[] list;
    static int[] memo;
    static int n,m;

    static void hacking(){
        boolean[] visited;
        Queue<Integer>q = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
            visited = new boolean[n+1];
            visited[i]=true;
            int cnt = 0;
            while(!q.isEmpty()){
                List<Integer> conn = list[q.poll()];
                for (int com : conn) {
                    if (visited[com]) continue;
                    visited[com] = true;
                    q.offer(com);
                    ++cnt;
                }
            }
            memo[i]=cnt;
            max = Math.max(cnt,max);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int sub = Integer.parseInt(st.nextToken());
            int dom = Integer.parseInt(st.nextToken());
            list[dom].add(sub);
        }

        memo = new int[n+1];
        hacking();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            if(memo[i]==max){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }
}