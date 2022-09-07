import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, num;
    static int k;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int idx, int depth) {
        if (depth == 6) {
            for (int i : num) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = idx; i < k; i++) {
            num[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bf.readLine();
            if (s.equals("0"))
                break;
            StringTokenizer st = new StringTokenizer(s);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            num = new int[6];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
