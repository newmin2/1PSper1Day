import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        sb.append("<");
        int i = 1;
        while (true) {
            if (i == k) {
                if (q.size() == 1) {
                    sb.append(q.poll()).append(">");
                    break;
                }
                sb.append(q.poll()).append(", ");
                i=1;
            }else {
                q.offer(q.poll());
                i++;
            }
        }
        System.out.println(sb);
    }
}

