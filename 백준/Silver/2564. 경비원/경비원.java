import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(bf.readLine());
        int[] dire = new int[num];
        int[] dist = new int[num];
        for (int t = 0; t < num; t++) {
            st = new StringTokenizer(bf.readLine());
            dire[t] = Integer.parseInt(st.nextToken());
            dist[t] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int pdire = Integer.parseInt(st.nextToken());
        int pdist = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum+=Math.min(Math.abs(func(dire[i],dist[i])-func(pdire,pdist)),2*(x+y)-Math.abs(func(dire[i],dist[i])-func(pdire,pdist)));
        }
        System.out.println(sum);
    }

    static int func(int a, int b) {
        int dist =0;
        if (a == 1) {
            dist= b;
        } else if (a == 3) {
            dist= 2*(x+y)-b;
        } else if (a == 2) {
            dist= 2*(x+y)-y-b;
        } else {
            dist = x+b;
        }
        return dist;
    }
}


