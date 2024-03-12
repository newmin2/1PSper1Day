import java.io.*;
import java.util.*;
public class Main {
    static Object bfs(int n, int t, int g){
        boolean[] visited = new boolean[100001];
        Queue<int[]>q = new ArrayDeque<>();
        q.offer(new int[]{n,0});
        visited[n]=true;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            if(arr[0]==g){
                return arr[1];
            }
            if(arr[1]>=t) continue;
            if(arr[0]<100000&&!visited[arr[0]+1]) {
                visited[arr[0]+1]=true;
                q.offer(new int[]{arr[0] + 1, arr[1] + 1});
            }

            int next = arr[0]*2;
            int tmp = next - (int) Math.pow(10, (int) Math.log10(next));
            if(next<100000&&!visited[tmp]){
                visited[tmp]=true;
                q.offer(new int[]{tmp,arr[1]+1});
            }
        }
        return "ANG";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n,t,g));
    }
}