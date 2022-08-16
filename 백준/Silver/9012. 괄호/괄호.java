import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Character> stack = new Stack<>();
        loop:
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < s.length(); j++) {
                char pc = s.charAt(j);
                if (pc == '(')
                    stack.push(pc);
                else if (stack.isEmpty()) {
                    System.out.println("NO");
                    continue loop;
                } else stack.pop();
            }
            if (stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
            stack.clear();
        }
    }
}

