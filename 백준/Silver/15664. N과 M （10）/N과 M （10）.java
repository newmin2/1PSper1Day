import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static void nnm(int a,int depth) {
        if (depth == m) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb2.append(arr[fake[i]]).append(' ');
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2).append('\n');
                set.add(sb2.toString());
            }
            return;
        }
        for (int i = a; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                fake[depth] = i;
                nnm(i+1,depth + 1);
                visited[i] = false;
            }
        }
    }

    static int[] arr, fake;
    static HashSet<String> set = new HashSet<>();
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        fake = new int[m];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        visited = new boolean[n];
        nnm(0,0);
        System.out.println(sb);
    }
}
