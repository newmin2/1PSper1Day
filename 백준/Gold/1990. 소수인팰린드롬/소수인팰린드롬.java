import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isPalin(int a){
        int n =a;
        int k=0;
        while(n>0){
            k*=10;
            k+=n%10;
            n/=10;
        }
        if(a==k)
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[b+1];
        prime[0]=prime[1]=true;

        for(int i=2; i*i<=b; i++){
            if(!prime[i]){
                for(int j=i*i; j<=b; j+=i){
                    prime[j]=true;
                }
            }
        }
        for(int i=a; i<=b; i++){
            if(!prime[i]){
                if(isPalin(i)) {
                    System.out.println(i);
                }
            }
        }
        System.out.println(-1);
    }
}
