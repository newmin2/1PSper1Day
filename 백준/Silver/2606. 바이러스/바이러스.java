import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int n, cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    static void dfs(int i) {
        if (visited[i])
            return;
        cnt++;
        visited[i] = true;
        for (int j = 0; j < list[i].size(); j++) {
            dfs(list[i].get(j));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        System.out.println(cnt-1);
    }
}
