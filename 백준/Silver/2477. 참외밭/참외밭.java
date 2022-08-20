import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> dirQ = new LinkedList<>();
        Queue<Integer> sizeQ = new LinkedList<>();
        int[] cnt = new int[5];
        StringTokenizer st;
        int dir;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(bf.readLine());
            dir = Integer.parseInt(st.nextToken());
            dirQ.offer(dir);
            sizeQ.offer(Integer.parseInt(st.nextToken()));
            cnt[dir]++;
        }
        int big = 1;
        while (dirQ.size() != 4) {
            if (cnt[dirQ.peek()] == 1) {
                dirQ.poll();
                big *= sizeQ.poll();
            } else {
                dirQ.offer(dirQ.poll());
                sizeQ.offer(sizeQ.poll());
            }
        }
        sizeQ.poll();
        int small = sizeQ.poll() * sizeQ.poll();
        System.out.println((big - small) * n);
    }
}

