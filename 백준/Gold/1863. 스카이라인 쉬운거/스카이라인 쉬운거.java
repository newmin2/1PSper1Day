import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        q.offer(0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            st.nextToken();
            q.offer(Integer.parseInt(st.nextToken()));
        }
        q.offer(0);
        int sum = 0;
        stack.push(0);
        while (!q.isEmpty()) {
            int b = q.poll();
            if (stack.peek() > b) {
                while (!stack.isEmpty() && stack.peek() > b) {
                    stack.pop();
                    sum++;
                }
                if (stack.isEmpty() || stack.peek() != b) {
                    stack.push(b);
                }
            } else if (stack.peek() < b) {
                stack.push(b);
            }
        }
        System.out.println(sum);
    }
}