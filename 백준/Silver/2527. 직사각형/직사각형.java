import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (c < e || d < f || g < a || h < b)
                System.out.println("d");
            else if ((c == e && b == h) || (c == e && d == f) || (g == a && f == d) || (g == a && h == b))
                System.out.println("c");
            else if (b == h || c == e || f == d || a == g)
                System.out.println("b");
            else
                System.out.println("a");
        }
    }
}