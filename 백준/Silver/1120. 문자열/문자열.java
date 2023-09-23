import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int cnt = 0, cnt2;
        for (int j = 0; j <= b.length() - a.length(); j++) {
            cnt2 = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(j + i)) {
                    cnt2++;
                }
            }
            cnt = Math.max(cnt, cnt2);
        }
        System.out.println(a.length() - cnt);
    }
}