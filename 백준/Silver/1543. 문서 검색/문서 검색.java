import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String docum = bf.readLine();
        String s = bf.readLine();
        int max = 0;
        for (int j = 0; j < docum.length(); j++) {
            int cnt = 0;
            int idx = 0;
            for (int i = j; i < docum.length(); i++) {
                if (docum.charAt(i) == s.charAt(idx)) {
                    ++idx;
                    if (idx >= s.length()) {
                        idx = 0;
                        ++cnt;
                    }
                } else {
                    idx = 0;
                }
            }
            max = Math.max(cnt,max);
        }
        System.out.println(max);
    }
}
