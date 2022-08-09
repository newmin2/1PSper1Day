import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> q = new LinkedList<>();
        int back=0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String s1 = st.nextToken();
            String s2 = null;
            if(st.hasMoreTokens())
                s2 = st.nextToken();
            if(s1.equals("push")) {
                back=Integer.parseInt(s2);
                q.offer(back);
            }
            else if(s1.equals("front"))
                if(!q.isEmpty())
                    System.out.println(q.peek());
                else
                    System.out.println(-1);
            else if(s1.equals("back"))
                if(!q.isEmpty())
                    System.out.println(back);
                else
                    System.out.println(-1);
            else if(s1.equals("pop"))
                if(!q.isEmpty())
                    System.out.println(q.poll());
                else
                    System.out.println(-1);
            else if(s1.equals("empty"))
                if(q.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            else if(s1.equals("size"))
                System.out.println(q.size());
        }
    }
}
