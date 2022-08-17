import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(bf.readLine());
            if (a == 0)
                stack.pop();
            else
                stack.push(a);
        }
        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        System.out.println(sum);
    }
}
