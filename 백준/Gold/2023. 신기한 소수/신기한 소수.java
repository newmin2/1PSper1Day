import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static boolean az(StringBuilder sb) {
        int a= Integer.parseInt(sb.toString());
        for(int i=2;i<(int)Math.sqrt(a);i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
    static void wow(int depth) {
        if (!az(sb))
            return;
        if (depth == n-1) {
            sb2.append(sb).append('\n');
            return;
        }
        for (int i = 0; i < 4; i++) {
            sb.append(arr[i]);
            wow(depth + 1);
            sb.deleteCharAt(depth+1);
        }
    }

    static int[] arr = {1, 3, 7, 9};
    static boolean[] sosu;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] first = {2, 3, 5, 7};
        for(int i :first){
            sb.append(i);
            wow(0);
            System.out.print(sb2);
            sb.setLength(0);
            sb2.setLength(0);
        }
    }
}