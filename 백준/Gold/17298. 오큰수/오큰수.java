import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        int[] memo = new int[n];
        memo[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            memo[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : memo) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
