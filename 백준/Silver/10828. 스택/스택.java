import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer>stack = new Stack<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String s1 = st.nextToken();
            String s2 = null;
            if(st.hasMoreTokens())
                s2 = st.nextToken();
            if(s1.equals("push"))
                stack.push(Integer.parseInt(s2));
            else if(s1.equals("top"))
                if(!stack.isEmpty())
                    System.out.println(stack.peek());
                else
                    System.out.println(-1);
            else if(s1.equals("pop"))
                if(!stack.isEmpty())
                    System.out.println(stack.pop());
                else
                    System.out.println(-1);
            else if(s1.equals("empty"))
                if(stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            else if(s1.equals("size"))
                System.out.println(stack.size());
        }
    }
}
