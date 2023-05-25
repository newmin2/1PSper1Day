import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int a;
        int ans=0;
        for(int i=0;i<n;i++){
            a = Integer.parseInt(bf.readLine());
            for(int j=2;j<=a;j++){
                int tmp =a;
                while(tmp%j==0){
                    ans++;
                    tmp/=j;
                }
            }
            System.out.println(ans);
            ans=0;
        }
    }
}
