import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if(n==1){
            System.out.println(1);
            return;}
        int a = 1;
        while (n > a) {
            a *= 2;
        }
        a/=2;
        System.out.println((n-a)*2);
    }
}