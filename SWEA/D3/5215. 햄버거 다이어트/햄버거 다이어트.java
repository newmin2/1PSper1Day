import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int max;
    static int l;
    static int[] arr;
    static int[] arr2;
    static void Jmt(int i, int sum, int sum2) {
        if (sum2 > l)
            return;
        if(i==arr.length){
            max = Math.max(sum, max);
            return;
        }

        Jmt(i + 1, sum + arr[i], sum2 + arr2[i]);
        Jmt(i + 1, sum, sum2);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            arr = new int[n];
            arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            max = 0;
            Jmt(0, 0, 0);
            System.out.println("#"+t+" "+max);
        }
    }
}