import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt =0;
        boolean[] isPrime = new boolean[n+1];
        for(int i=2;i<=n;i++){
            if (isPrime[i])continue;
            isPrime[i]=true;
            cnt++;
            if(cnt==k){
                System.out.println(i);
                return;
            }
            for(int j=i*i;j<=n;j+=i){
                if (isPrime[j])continue;
                isPrime[j]=true;
                cnt++;
                if(cnt==k){
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}