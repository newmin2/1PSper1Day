import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] arr;
    static boolean[][] visited;
    static double ans;

    static void robot(int x,int y,int depth,double mul) {
        if(visited[x][y])
            return;
        if (arr[0] == depth) {
            ans+=mul;
            return;
        }
        visited[x][y]=true;
        for (int i = 1; i < 5; i++) {
            if(arr[i]!=0) {
                if (i == 1)
                    robot(x, y + 1, depth + 1,mul*(double)arr[i]/100);
                else if (i == 2)
                    robot(x, y - 1, depth + 1,mul*(double)arr[i]/100);
                else if (i == 3)
                    robot(x + 1, y, depth + 1,mul*(double)arr[i]/100);
                else
                    robot(x - 1, y, depth + 1,mul*(double)arr[i]/100);
            }
        }
        visited[x][y]=false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[29][29];
        robot(14,14,0,1);
        System.out.println(ans);
    }
}
