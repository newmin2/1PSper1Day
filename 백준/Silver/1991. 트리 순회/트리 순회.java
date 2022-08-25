import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr;
    static int n;
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static StringBuilder sb3 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        arr = new String[n + 1][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
        }
        binatree(0, 0);
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb3);
    }

    static void binatree(int i, int j) {
        if (arr[i][j].equals(".") || i > n - 1)
            return;
        sb1.append(arr[i][j]);
        for (int k = 0; k < n; k++) {
            if (arr[k][0].equals(arr[i][1]))
                binatree(k, 0);
        }
        sb2.append(arr[i][j]);
        for (int k = 0; k < n; k++) {
            if (arr[k][0].equals(arr[i][2]))
                binatree(k, 0);
        }
        sb3.append(arr[i][j]);
    }
}
